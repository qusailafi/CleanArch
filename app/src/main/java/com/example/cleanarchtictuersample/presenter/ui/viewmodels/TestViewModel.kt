package com.example.cleanarchtictuersample.presenter.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.cleanarchtictuersample.domain.model.Resource
import com.example.cleanarchtictuersample.domain.usecases.TestUseCase
import dagger.assisted.AssistedFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import okhttp3.Response
import okhttp3.ResponseBody
import javax.inject.Inject

@HiltViewModel
class TestViewModel : BaseViewModel{
    var response = MutableStateFlow<Resource<ResponseBody>>(Resource.loading(null))
    var testUseCase: TestUseCase

    @Inject
    constructor(testUseCase: TestUseCase) {
        this.testUseCase = testUseCase


    }

    fun test(): StateFlow<Resource<ResponseBody>> {
        viewModelScope.launch {

            response.value = testUseCase()

        }
        return response

    }

}