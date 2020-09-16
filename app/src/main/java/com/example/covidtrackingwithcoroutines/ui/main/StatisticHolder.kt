package com.example.covidtrackingwithcoroutines.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covidtrackingwithcoroutines.R
import com.example.covidtrackingwithcoroutines.domain.CovidStatistic
import kotlinx.android.synthetic.main.statistic_item.view.*

class StatisticHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        fun createInstance(parent: ViewGroup) = StatisticHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.statistic_item,
                parent,
                false
            )
        )
    }

    private lateinit var item: CovidStatistic

    fun bind(cafeItem: CovidStatistic) {
        this.item = cafeItem

        itemView.country.text = cafeItem.keyId
        itemView.city.text = cafeItem.city
        itemView.confirmedValue.text = cafeItem.confirmed.toString()
        itemView.deathsValue.text = cafeItem.deaths.toString()
    }
}