package com.example.covidtrackingwithcoroutines.data

import retrofit2.http.GET
import retrofit2.http.Headers

interface CovidStatisticApi {

    @GET("stats")
    @Headers(
        "x-rapidapi-host: covid-19-coronavirus-statistics.p.rapidapi.com",
        "x-rapidapi-key: 567c474a73msh7e33088fa586f9bp18926djsn530c81c0e5a4"
    )
    suspend fun getAllCovidStatistic(): CovidStatisticResponse
}