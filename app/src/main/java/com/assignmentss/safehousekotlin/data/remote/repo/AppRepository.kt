package com.assignmentss.safehousekotlin.data.remote.repo

import androidx.lifecycle.MutableLiveData
import com.assignmentss.safehousekotlin.data.remote.api.APIService
import com.assignmentss.safehousekotlin.data.remote.model.CharacterItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppRepository (private val apiService: APIService) {
    private lateinit var data:MutableLiveData<List<CharacterItem>>

    suspend fun getCharacters():MutableLiveData<List<CharacterItem>>{
        apiService.getCharacters().enqueue( object : Callback<List<CharacterItem>> {
            override fun onResponse(call: Call<List<CharacterItem>>?, response: Response<List<CharacterItem>>?) {
                data.postValue(response!!.body())
            }

            override fun onFailure(call: Call<List<CharacterItem>>?, t: Throwable?) {

            }
        })
        return data
    }
}