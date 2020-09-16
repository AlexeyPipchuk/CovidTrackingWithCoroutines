package com.example.covidtrackingwithcoroutines.domain

import java.util.*

data class CovidStatistic(
    val city: String?,
    val province: String?,
    val country: String,
    val lastUpdate: Date,
    val keyId: String,
    val confirmed: Long?,
    val deaths: Long?,
    val recovered: Long?
)