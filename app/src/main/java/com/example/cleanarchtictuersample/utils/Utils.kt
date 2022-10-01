package com.example.cleanarchtictuersample.utils

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager

class Utils {
    companion object{
        fun isInternetConnected(application: Application): Boolean {
            val conMgr =
                application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = conMgr.activeNetworkInfo
            return if (netInfo == null) false else true
        }

    }
}