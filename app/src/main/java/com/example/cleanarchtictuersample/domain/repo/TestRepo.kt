package com.example.cleanarchtictuersample.domain.repo

import com.example.cleanarchtictuersample.domain.model.Resource
import kotlinx.coroutines.flow.Flow
import okhttp3.Response
import okhttp3.ResponseBody

interface TestRepo {
    suspend fun testApi( apiName:String):   Resource<ResponseBody>

}