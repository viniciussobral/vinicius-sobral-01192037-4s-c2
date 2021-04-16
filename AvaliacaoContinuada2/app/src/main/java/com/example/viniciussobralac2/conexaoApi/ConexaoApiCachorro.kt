package com.example.viniciussobralac2.conexaoApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConexaoApiCachorro {

    fun criar(): ApiCachorro{

        return Retrofit.Builder()
            .baseUrl("https://5f861cfdc8a16a0016e6aacd.mockapi.io/bandtec-api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiCachorro::class.java)

    }
}