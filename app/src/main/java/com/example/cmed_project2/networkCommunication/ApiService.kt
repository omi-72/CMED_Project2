package com.example.cmed_project2.networkCommunication


import retrofit2.Call
import retrofit2.http.GET
interface ApiService {

    @GET("characters")
    fun getCharacters(): Call<List<Character>>
}