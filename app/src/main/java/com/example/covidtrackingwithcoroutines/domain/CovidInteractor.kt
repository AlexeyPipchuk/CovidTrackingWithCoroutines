package com.example.covidtrackingwithcoroutines.domain

import com.example.covidtrackingwithcoroutines.data.CovidStatisticDataSource

class CovidInteractor {

    companion object {
        val datasource = CovidStatisticDataSource()
    }

    suspend fun getStatistic(): List<CovidStatistic> =
        datasource.getAllCovidStatistic()
}