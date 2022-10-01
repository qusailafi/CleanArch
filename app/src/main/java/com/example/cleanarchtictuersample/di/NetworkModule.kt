package com.example.cleanarchtictuersample.di

import com.example.cleanarchtictuersample.data.remote.ApiServices
//import com.chuckerteam.chucker.api.ChuckerInterceptor
//import com.giphy.sdk.analytics.GiphyPingbacks.context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import java.util.concurrent.TimeUnit


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("")
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHtttpClient(): OkHttpClient {
//        val certificatePinner: CertificatePinner = CertificatePinner.Builder()
//            .add(BuildConfig.ROOT_API, "sha256/WoiWRyIOVNa9ihaBciRSC7XHjliYS9VwUGOIud4PB18=")
//            .build()

        var okHttpClient: OkHttpClient.Builder =
            OkHttpClient.Builder()
//                .certificatePinner(certificatePinner)
                .addInterceptor(object : Interceptor {
                    override fun intercept(chain: Interceptor.Chain): Response {

                        val request =
                            chain.request().newBuilder().addHeader(
                                "Auth",
                                ""

                            )

                                .build()
                        return chain.proceed(request)
                    }

                })
                .addInterceptor(Interceptor { chain ->
                    val request: Request = chain.request()
                    var response = chain.proceed(request)
                    when (response.code) {
                        401 -> {
//un Auth
                        }
                        409 -> {

                            // if socket time out
                        }
                    }

                    response
                })

        okHttpClient.readTimeout(1, TimeUnit.MINUTES)
        okHttpClient.writeTimeout(1, TimeUnit.MINUTES)


        var client: OkHttpClient = okHttpClient.build()
        return client
    }


    @Provides
    @Singleton
    fun apiService(): ApiServices {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/pokemon/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHtttpClient())
            .build()
            .create(ApiServices::class.java)
    }

}