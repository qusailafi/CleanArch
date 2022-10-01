package com.example.cleanarchtictuersample.application

import android.app.Application

import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp:Application() {
    companion object{
        var instance: MyApp?=null
         @JvmName("getInstance1")
        fun getInstance(): MyApp {
            return instance!!
        }
    }
    override fun onCreate() {
        super.onCreate()
        instance =this

     }
}