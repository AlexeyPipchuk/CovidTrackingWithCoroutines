package com.example.covidtrackingwithcoroutines.data

data class CovidStatisticResponse (
    val error: Boolean,
    val statusCode: Int,
    val message: String,
    val data: CovidStatisticModel
)