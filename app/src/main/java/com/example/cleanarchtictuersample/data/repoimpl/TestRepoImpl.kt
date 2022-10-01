package com.example.cleanarchtictuersample.data.repoimpl

import com.example.cleanarchtictuersample.data.manger.RequestManger
import com.example.cleanarchtictuersample.domain.model.Resource
import com.example.cleanarchtictuersample.domain.repo.TestRepo
import okhttp3.ResponseBody
import javax.inject.Inject

class TestRepoImpl : TestRepo {
    var manger: RequestManger

    @Inject
    constructor(manger: RequestManger) {
        this.manger = manger

    }

    override suspend fun testApi(apiName: String): Resource<ResponseBody> {
        return manger.getRequest(apiName)
    }


}