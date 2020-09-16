package com.example.covidtrackingwithcoroutines.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covidtrackingwithcoroutines.R
import com.example.covidtrackingwithcoroutines.domain.CovidStatistic
import kotlinx.android.synthetic.main.main_fragment.*
import java.util.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    lateinit var viewModel: MainViewModel
    private var adapter: StatisticAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        initObservers()

        showProgress()
        viewModel.load()
    }

    private fun showProgress() {
        progressBar.isVisible = true
    }

    private fun hideProgress() {
        progressBar.isVisible = false
    }

    private fun initObservers() {
        viewModel.covidStatistic.observeForever { statistics ->
            hideProgress()
            initAdapter(statistics)
        }

        viewModel.toastEvent.observeForever { toastText ->
            Toast.makeText(requireContext(), toastText, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initAdapter(cafeItemList: List<CovidStatistic>) {
        adapter = StatisticAdapter()
        adapter?.statisticItems = cafeItemList

        CovidStatisticsRecycler.layoutManager =
            GridLayoutManager(requireContext(), 5, RecyclerView.HORIZONTAL, false)
        CovidStatisticsRecycler.adapter = adapter
        CovidStatisticsRecycler.isVisible = true
    }
}
