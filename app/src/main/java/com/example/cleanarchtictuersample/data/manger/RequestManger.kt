package com.example.cleanarchtictuersample.data.manger

import com.example.cleanarchtictuersample.application.MyApp
import com.example.cleanarchtictuersample.data.remote.ApiServices
import com.example.cleanarchtictuersample.domain.model.ErrorResponse
import com.example.cleanarchtictuersample.domain.model.Resource
import com.example.cleanarchtictuersample.utils.ApiStatus
import com.example.cleanarchtictuersample.utils.Utils
import com.google.gson.Gson

import okhttp3.ResponseBody
import javax.inject.Inject

class RequestManger {

    var apiServices: ApiServices

    @Inject
    constructor(apiServices: ApiServices) {
        this.apiServices = apiServices
    }


    suspend fun getRequest(apiName: String): Resource<ResponseBody> {
        return if (Utils.Companion.isInternetConnected(MyApp.getInstance())) {
            return try {

                val myResp = apiServices.getRequest(apiName)

                if (myResp.isSuccessful) {
                    Resource.success(myResp.body()!!)
                } else {
                    var gson: Gson = Gson()
                    var errorObj: ErrorResponse = ErrorResponse("")
                    errorObj =
                        gson.fromJson(myResp.errorBody()?.string()!!, ErrorResponse::class.java)
                    when (myResp.code()) {
                        400 -> {

                            Resource.error(null, ApiStatus.ERROR, errorObj.message)

                        }
                        404 -> {
                            Resource.error(null, ApiStatus.ERROR, errorObj.message)

                        }
                        500 -> {
                            Resource.error(null, ApiStatus.ERROR, errorObj.message)

                        }
                        401 -> {
                            Resource.unAuthraize(null, ApiStatus.UNAUTHRAIZE, errorObj.message)

                        }
                        else ->
                            Resource.error(null, ApiStatus.ERROR, errorObj.message)

                    }

                }

            } catch (e: Exception) {
                Resource.error(null, ApiStatus.ERROR, e.message.toString())
            }
        } else
            Resource.noInterNet()


    }

    suspend fun postRequestFormUrl(
        apiName: String,
        obj: HashMap<String, Any>
    ): Resource<ResponseBody> {
        return if (Utils.Companion.isInternetConnected(MyApp.getInstance())) {
            return try {

                val myResp = apiServices.postRequestUrlEncoded(apiName, obj)


                if (myResp.isSuccessful) {
                    Resource.success(myResp.body()!!)
                } else {
                    var gson: Gson = Gson()
                    var errorObj: ErrorResponse = ErrorResponse("")
                    errorObj =
                        gson.fromJson(myResp.errorBody()?.string()!!, ErrorResponse::class.java)
                    when (myResp.code()) {
                        400 -> {

                            Resource.error(null, ApiStatus.ERROR, errorObj.message)

                        }
                        404 -> {
                            Resource.error(null, ApiStatus.ERROR, errorObj.message)

                        }
                        500 -> {
                            Resource.error(null, ApiStatus.ERROR, errorObj.message)

                        }
                        401 -> {
                            Resource.unAuthraize(null, ApiStatus.UNAUTHRAIZE, errorObj.message)

                        }
                        else ->
                            Resource.error(null, ApiStatus.ERROR, errorObj.message)

                    }

                }

            } catch (e: Exception) {
                Resource.error(null, ApiStatus.ERROR, e.message.toString())
            }
        } else
            Resource.noInterNet()


    }

    suspend fun postRequest(apiName: String, obj: Any): Resource<ResponseBody> {
        return if (Utils.Companion.isInternetConnected(MyApp.getInstance())) {
            return try {

                val myResp = apiServices.postRequest(apiName, obj)


                if (myResp.isSuccessful) {
                    Resource.success(myResp.body()!!)
                } else {
                    var gson: Gson = Gson()
                    var errorObj: ErrorResponse = ErrorResponse("")
                    errorObj =
                        gson.fromJson(myResp.errorBody()?.string()!!, ErrorResponse::class.java)
                    when (myResp.code()) {
                        400 -> {

                            Resource.error(null, ApiStatus.ERROR, errorObj.message)

                        }
                        404 -> {
                            Resource.error(null, ApiStatus.ERROR, errorObj.message)

                        }
                        500 -> {
                            Resource.error(null, ApiStatus.ERROR, errorObj.message)

                        }
                        401 -> {
                            Resource.unAuthraize(null, ApiStatus.UNAUTHRAIZE, errorObj.message)

                        }
                        else ->
                            Resource.error(null, ApiStatus.ERROR, errorObj.message)

                    }

                }

            } catch (e: Exception) {
                Resource.error(null, ApiStatus.ERROR, e.message.toString())
            }
        } else
            Resource.noInterNet()


    }


}