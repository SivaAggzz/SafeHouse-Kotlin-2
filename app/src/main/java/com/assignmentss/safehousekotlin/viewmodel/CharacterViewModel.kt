package com.assignmentss.safehousekotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignmentss.safehousekotlin.data.remote.model.CharacterItem
import com.assignmentss.safehousekotlin.data.remote.repo.AppRepository
import kotlinx.coroutines.launch

class CharacterRepository constructor(private val appRepo: AppRepository)  : ViewModel() {
    val characterItems = MutableLiveData<List<CharacterItem>>()
    val errorMessage = MutableLiveData<String>()


    fun getCharacters() : MutableLiveData<List<CharacterItem>>{
        viewModelScope.launch {  appRepo.getCharacters() }
        return characterItems
    }



}
