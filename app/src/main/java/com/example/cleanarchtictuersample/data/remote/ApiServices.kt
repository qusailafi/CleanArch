package com.example.cleanarchtictuersample.data.remote

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ApiServices {

    @GET
    suspend fun getRequest(@Url apiName: String): Response<ResponseBody>

    @POST
    suspend fun postRequest(@Url apiName: String, @Body requestParams: Any): Response<ResponseBody>


    @FormUrlEncoded
    @POST
    suspend fun postRequestUrlEncoded(
        @Url apiName: String,
        @FieldMap requestParams: HashMap<String, Any>
    ): Response<ResponseBody>


}