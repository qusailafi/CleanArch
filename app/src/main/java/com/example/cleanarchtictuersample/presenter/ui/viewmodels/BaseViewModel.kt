package com.example.cleanarchtictuersample.presenter.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

open class BaseViewModel : ViewModel {
    var uiState: MutableLiveData<UIState>
    var msgUi:MutableLiveData<String>

    constructor() {
        uiState = MutableLiveData(UIState.LOADING)
        msgUi = MutableLiveData<String>("")
    }

    fun setUiMsg(state: String) {
        this.msgUi.value = state
    }

    fun setUiState(state: UIState) {
        uiState.value = state

    }

    fun getUiState(): LiveData<UIState> {
        return uiState

    }

    fun getUiMsg(): LiveData<String> {
        return msgUi

    }
}