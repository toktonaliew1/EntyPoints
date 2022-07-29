package com.example.entypoints.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4hw1.ui.adapters.CoinsAdapter
import com.example.entypoints.Either
import com.example.entypoints.R
import com.example.entypoints.databinding.FragmentCoinsBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinsFragment : Fragment(R.layout.fragment_coins) {

    private val binding by viewBinding(FragmentCoinsBinding::bind)
    private val viewModel: ViewModel by viewModels()
    private val heroesAdapter = CoinsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObserves()
    }

    private fun setupRecyclerView() = with(binding.recyclerHeroes) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = heroesAdapter
    }

    private fun setupObserves() {
        viewModel.fetchCoins().observe(viewLifecycleOwner) {
            when (it) {
                is Either.Left -> {
                    Log.e("anime", it.value)
                }
                is Either.Right -> {
                    Log.e("Anime", it.value.toString())
                    heroesAdapter.submitList(it.value)
                }
            }
        }
    }
}