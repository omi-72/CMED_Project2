package com.example.cmed_project2.networkCommunication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cmed_project2.model.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterRepository {
    private val apiService = Retrofit.Builder()
        .baseUrl("http://hp-api.herokuapp.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun getCharacters(): LiveData<List<Character>> {
        val data = MutableLiveData<List<Character>>()
        apiService.getCharacters().enqueue(object :
            Callback<List<Character>> {
            override fun onResponse(call: Call<List<Character>>, response: Response<List<Character>>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                // Handle failure
            }
        })
        return data
    }
}