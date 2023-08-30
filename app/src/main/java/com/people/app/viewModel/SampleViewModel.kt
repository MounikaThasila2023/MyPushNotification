package com.people.app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SampleViewModel : ViewModel() {
    private val _counter = MutableLiveData<Int>()
    val count: LiveData<Int> get() = _counter

    init {
        _counter.value = 0
    }

    fun incrementCounter() {
        _counter.value = (_counter.value ?: 0) + 1
    }
}