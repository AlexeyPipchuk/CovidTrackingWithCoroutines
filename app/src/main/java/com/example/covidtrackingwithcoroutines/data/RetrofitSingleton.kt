package com.example.covidtrackingwithcoroutines.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

object RetrofitSingleton {

    private val gson: Gson = GsonBuilder()
        .setDateFormat("yyyy.MM.dd")
        .create()

    private val httpLoggingInterceptor = HttpLoggingInterceptor {
        Timber.plant(Timber.DebugTree())
        Timber.tag("okhttp").d(it)
    }.apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient: OkHttpClient =
        OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
            .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .baseUrl("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/")
        .build()

    fun getApi(): CovidStatisticApi = retrofit.create(CovidStatisticApi::class.java)
}