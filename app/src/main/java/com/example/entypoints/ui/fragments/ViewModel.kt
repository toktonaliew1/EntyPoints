package com.example.entypoints.ui.fragments

import androidx.lifecycle.ViewModel

import com.example.entypoints.repository.CoinsRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val repository: CoinsRepository) :
    ViewModel() {

    fun fetchCoins() = repository.fetchCoins()
}