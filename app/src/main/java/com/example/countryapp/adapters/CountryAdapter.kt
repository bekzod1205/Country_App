package com.example.countryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.countryapp.ItemTouchHelperAdapter
import com.example.countryapp.databinding.CountryItemBinding
import com.example.countryapp.databinding.FragmentCountryBinding
import com.example.countryapp.datas.Country
import java.util.*

class CountryAdapter(var list: MutableList<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryHolder>(), ItemTouchHelperAdapter {
    inner class CountryHolder(binding: CountryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var name = binding.countryName
        var img = binding.countryImg
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        return CountryHolder(
            CountryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        val item = list[position]
        holder.name.text = item.name
        holder.img.load(item.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(list, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(list, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }
}