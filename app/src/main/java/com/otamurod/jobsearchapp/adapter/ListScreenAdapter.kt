package com.otamurod.jobsearchapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.otamurod.jobsearchapp.databinding.ItemListBinding

class ListScreenAdapter() : RecyclerView.Adapter<ListScreenAdapter.ViewHolder>() {
    var items = ArrayList<String>()

    @SuppressLint("NotifyDataSetChanged")
    fun setUpdatedData(items: ArrayList<String>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class ViewHolder(val itemListBinding: ItemListBinding) :
        RecyclerView.ViewHolder(itemListBinding.root) {
        fun onBind(job: String) {
            itemListBinding.textView.text = job
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount() = items.size
}