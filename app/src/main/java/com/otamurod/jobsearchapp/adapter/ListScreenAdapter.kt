package com.otamurod.jobsearchapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.otamurod.jobsearchapp.databinding.ItemListBinding
import com.otamurod.jobsearchapp.model.Location

class ListScreenAdapter() : RecyclerView.Adapter<ListScreenAdapter.VH>() {
    var items = ArrayList<Location>()

    @SuppressLint("NotifyDataSetChanged")
    fun setUpdatedData(items: ArrayList<Location>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class VH(val itemListBinding: ItemListBinding) :
        RecyclerView.ViewHolder(itemListBinding.root) {
        fun onBind(location: Location) {
            itemListBinding.textView.text = location.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount() = items.size
}