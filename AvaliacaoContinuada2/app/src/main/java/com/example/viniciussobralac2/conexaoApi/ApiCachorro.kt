package com.example.viniciussobralac2.conexaoApi

import retrofit2.Call
import retrofit2.http.*

interface ApiCachorro {

    @GET("cachorros")
    fun get(): Call<List<Cachorro>>

    @POST("cachorros")
    fun post(@Body novoCachorro:CriarCachorro): Call<Cachorro>
}