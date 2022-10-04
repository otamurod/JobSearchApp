package com.otamurod.jobsearchapp.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.otamurod.jobsearchapp.databinding.ItemListBinding

class ListScreenAdapter() : RecyclerView.Adapter<ListScreenAdapter.VH>() {

    inner class VH(val itemListBinding: ItemListBinding) :
        RecyclerView.ViewHolder(itemListBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}