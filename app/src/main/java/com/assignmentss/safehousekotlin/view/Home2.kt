package com.assignmentss.safehousekotlin.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.assignmentss.safehousekotlin.CharacterRepository
import com.assignmentss.safehousekotlin.R
import com.assignmentss.safehousekotlin.databinding.ActivityMainBinding

class Home2 : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val viewModel : CharacterRepository by viewModels()
    private var characterAdapter: CharacterAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)


        viewModel.getCharacters().observe(this, { items ->
            characterAdapter=
                CharacterAdapter(
                    applicationContext,
                    items
                )
            binding.recyclerView.setAdapter(characterAdapter);
        })
    }
}