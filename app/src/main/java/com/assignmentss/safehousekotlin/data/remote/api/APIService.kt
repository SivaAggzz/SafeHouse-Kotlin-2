package com.assignmentss.safehousekotlin.data.remote.api

import com.assignmentss.safehousekotlin.data.remote.model.CharacterItem
import com.assignmentss.safehousekotlin.utils.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIService {
    @GET("api/characters")
    suspend fun getCharacters(): Call<List<CharacterItem>>

    companion object {

        fun create() : APIService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
            return retrofit.create(APIService::class.java)

        }
    }
}