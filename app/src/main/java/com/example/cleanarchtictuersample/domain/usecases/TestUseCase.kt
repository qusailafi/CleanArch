package com.example.cleanarchtictuersample.domain.usecases

import com.example.cleanarchtictuersample.data.repoimpl.TestRepoImpl
import com.example.cleanarchtictuersample.utils.ApisName
import javax.inject.Inject

class TestUseCase  @Inject constructor(val repo: TestRepoImpl){
    suspend operator fun invoke()=repo.testApi(ApisName.DILTO)

}