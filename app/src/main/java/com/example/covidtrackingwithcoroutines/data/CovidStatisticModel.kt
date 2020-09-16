package com.example.covidtrackingwithcoroutines.data

import com.example.covidtrackingwithcoroutines.domain.CovidStatistic

data class CovidStatisticModel(
    val lastChecked: String,
    val covid19Stats: List<CovidStatistic>
)