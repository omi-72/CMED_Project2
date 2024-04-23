package com.example.cmed_project2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cmed_project2.model.Character
import com.example.cmed_project2.networkCommunication.CharacterRepository

class CharacterViewModel : ViewModel() {
    private val repository = CharacterRepository()

    fun getCharacters(): LiveData<List<Character>> {
        return repository.getCharacters()
    }
}