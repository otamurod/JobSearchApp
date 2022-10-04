package com.otamurod.jobsearchapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.otamurod.jobsearchapp.databinding.ItemListBinding

class ListScreenAdapter() : RecyclerView.Adapter<ListScreenAdapter.VH>() {

    inner class VH(val itemListBinding: ItemListBinding) :
        RecyclerView.ViewHolder(itemListBinding.root) {
        fun onBind() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind()
    }

    override fun getItemCount(): Int {
        // TODO: return list.size
    }
}