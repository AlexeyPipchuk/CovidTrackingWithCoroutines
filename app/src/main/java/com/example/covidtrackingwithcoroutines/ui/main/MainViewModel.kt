package com.example.covidtrackingwithcoroutines.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covidtrackingwithcoroutines.domain.CovidInteractor
import com.example.covidtrackingwithcoroutines.domain.CovidStatistic
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {

    private val covidInteractor = CovidInteractor()
    var covidStatistic: MutableLiveData<List<CovidStatistic>> = MutableLiveData()
    val toastEvent: MutableLiveData<String> = MutableLiveData()

    private var counter = 0

    fun load() {

        MainScope().launch {
            val mainJob = MainScope().launch {
                covidStatistic.value = covidInteractor.getStatistic()
            }
            mainJob.join()

            val deferred1Sec = MainScope().async {
                do1Sec()
            }

            val deferred1Sec2 = MainScope().async {
                do1Sec()
            }

            toastEvent.value = deferred1Sec.await() + " " + deferred1Sec2.await()

            List(5) {
                launch {
                    delay(1000L)
                    counter += 1
                    toastEvent.value = counter.toString()
                }
            }

            toastEvent.value = "end"
        }

        toastEvent.value = "start"
    }

    private suspend fun do1Sec(): String {
        delay(1000L)
        return "async 1sec"
    }
}