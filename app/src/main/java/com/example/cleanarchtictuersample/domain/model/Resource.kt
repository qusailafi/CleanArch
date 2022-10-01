package com.example.cleanarchtictuersample.domain.model

import com.example.cleanarchtictuersample.utils.ApiStatus


class Resource<out T>(val status: ApiStatus, val data: T?, val msg:String) {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(status = ApiStatus.SUCCESS, data = data,msg = "")

        fun <T> error(data: T?, status: ApiStatus,msg:String): Resource<T> =
            Resource(status = status, data = data,msg=msg)

        fun <T> noInterNet(): Resource<T> =
            Resource(status = ApiStatus.NOTINTERNET,data = null,msg = "")
        fun <T> loading(data: T?): Resource<T> = Resource(status = ApiStatus.LOADING, data = data,msg = "")
        fun <T> unAuthraize(data: T?, status: ApiStatus,msg:String): Resource<T> =
            Resource(status = status, data = data,msg=msg)

    }

}