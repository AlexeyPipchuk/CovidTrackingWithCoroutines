package com.example.covidtrackingwithcoroutines.ui.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covidtrackingwithcoroutines.domain.CovidStatistic

class StatisticAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var statisticItems: List<CovidStatistic> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        StatisticHolder.createInstance(parent)

    override fun getItemCount(): Int = statisticItems.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as StatisticHolder
        holder.bind(statisticItems[position])
    }
}