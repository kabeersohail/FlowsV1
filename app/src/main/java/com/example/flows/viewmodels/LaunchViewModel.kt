package com.example.flows.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LaunchViewModel: ViewModel() {
    private val _sharedFlow: MutableSharedFlow<Int> = MutableSharedFlow()
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun squareNumber(number: Int) {

        viewModelScope.launch {
            _sharedFlow.emit(number * number)
        }
    }

}