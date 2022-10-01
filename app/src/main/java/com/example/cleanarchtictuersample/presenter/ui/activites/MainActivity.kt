package com.example.cleanarchtictuersample.presenter.ui.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchtictuersample.R
import com.example.cleanarchtictuersample.databinding.ActivityMainBinding
import com.example.cleanarchtictuersample.presenter.ui.viewmodels.TestViewModel
import com.example.cleanarchtictuersample.presenter.ui.viewmodels.UIState
import com.example.cleanarchtictuersample.utils.ApiStatus
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    val viewModel: TestViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.loadingView.loading = viewModel.getUiState()
        binding.noInternet.loading = viewModel.getUiState()
        binding.serverError.loading = viewModel.getUiState()

        binding.serverError.msg = viewModel.getUiMsg()

        binding.noInternet.msg = viewModel.getUiMsg()

        lifecycleScope.launch {
            viewModel.test().collect {
                viewModel.setUiMsg(it.status.name.toString())

                when (it.status) {
                    ApiStatus.LOADING -> {
                        viewModel.setUiState(UIState.LOADING)
                        Log.d("ApiStatus", it.status.name)
                    }

                    ApiStatus.SUCCESS -> {
                        viewModel.setUiState(UIState.SUCCESS)

                        Log.d("ApiStatus", it.status.name)

                    }
                    ApiStatus.ERROR -> {
                        viewModel.setUiState(UIState.SERVER_ERROR)
                        viewModel.setUiMsg(it.msg)

                        Log.d("ApiStatus", it.status.name)

                    }
                    ApiStatus.NOTINTERNET -> {
                        viewModel.setUiState(UIState.NETWORK_ERROR)

                        Log.d("ApiStatus", it.status.name)


                    }
                    ApiStatus.UNAUTHRAIZE -> {
                        viewModel.setUiState(UIState.UNAUTHRAIZE)


                    }
                }
            }
        }
    }
}