package com.otamurod.jobsearchapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
        viewModel.getUsers("")
        viewModel.jobs
            .observe(viewLifecycleOwner, Observer<ListItemModel> { listItemModel ->
                if (listItemModel != null) { //check if response is not null
                    adapter.setUpdatedData(listItemModel.jobs) //set data to adapter
                } else {
                    Toast.makeText(activity, "Error getting data", Toast.LENGTH_SHORT)
                        .show() //notify about response error
                }
            })
    }
}