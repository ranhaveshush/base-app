package com.example.baseapp.api.github

import com.example.baseapp.BuildConfig
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://api.github.com/"

class GitHubApi {
    val service: GitHubService = create(
        HttpUrl.parse(BASE_URL)!!,
        GitHubService::class.java
    )

    private fun <ServiceT> create(
        baseUrl: HttpUrl,
        serviceClass: Class<ServiceT>
    ): ServiceT {
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            })
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit.create(serviceClass)
    }
}
