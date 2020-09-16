package com.example.covidtrackingwithcoroutines.data

import com.example.covidtrackingwithcoroutines.domain.CovidStatistic
import kotlinx.coroutines.Deferred

class CovidStatisticDataSource {

    private val api = RetrofitSingleton.getApi()

    suspend fun getAllCovidStatistic(): List<CovidStatistic> =
        api.getAllCovidStatistic().data.covid19Stats
}