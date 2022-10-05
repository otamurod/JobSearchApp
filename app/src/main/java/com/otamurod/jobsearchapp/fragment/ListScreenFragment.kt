package com.otamurod.jobsearchapp.fragment

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.otamurod.jobsearchapp.adapter.ListScreenAdapter
import com.otamurod.jobsearchapp.databinding.FragmentListScreenBinding
import com.otamurod.jobsearchapp.model.ListItemModel

class ListScreenFragment : Fragment() {
    //declare variables
    lateinit var listScreenBinding: FragmentListScreenBinding
    lateinit var viewModel: ListScreenViewModel
    lateinit var adapter: ListScreenAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        listScreenBinding = FragmentListScreenBinding.inflate(layoutInflater)
        return listScreenBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViewModel() //initialize ViewModel in Fragment
        initAdapter() //initializes adapter

        super.onViewCreated(view, savedInstanceState)
    }

    private fun initAdapter() {
        adapter = ListScreenAdapter()
        listScreenBinding.recyclerView.adapter = adapter
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(ListScreenViewModel::class.java) //get viewModel
        //check network state, because we use Retrofit to get data from API
        checkNetworkStatus()

        viewModel.getLiveData()
            .observe(viewLifecycleOwner, Observer<ListItemModel> { listItemModel ->
                if (listItemModel != null) { //check if response is not null
                    adapter.setUpdatedData(listItemModel.jobs) //set data to adapter
                } else {
                    Toast.makeText(activity, "Error getting data", Toast.LENGTH_SHORT)
                        .show() //notify about response error
                }
            })
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun checkNetworkStatus() {
        val conMgr =
            activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as (ConnectivityManager)
        val activeNetwork = conMgr.activeNetworkInfo;
        if (activeNetwork != null && activeNetwork.isConnected) {
            // notify user you are online
            Toast.makeText(activity, "Network State: Online", Toast.LENGTH_SHORT).show()
            makeAPICall() //send request to API when online
        } else {
            // notify user you are not online
            Toast.makeText(activity, "Network State: Offline", Toast.LENGTH_LONG).show()
        }

        networkChangeListener() //create network state listener
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun networkChangeListener() {
        val connectivityManager =
            activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.let {
            it.registerDefaultNetworkCallback(object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    //take action when network connection is gained
                    Toast.makeText(context, "Back Online", Toast.LENGTH_SHORT).show()
                    makeAPICall() //again call to API when network available
                }

                override fun onLost(network: Network) {
                    //take action when network connection is lost
                    Toast.makeText(context, "You are Offline", Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    private fun makeAPICall() {
        val query = "page=1" //query to send to API
        viewModel.sendQuery(query) //send query
    }
}