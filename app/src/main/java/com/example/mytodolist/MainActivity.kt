package com.example.mytodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mytodolist.databinding.ActivityMainBinding
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                    // Inflate the activity_main. xml and attach it to binding variable
                    binding = ActivityMainBinding.inflate (layoutInflater)
                    // set the contents on the screen with the binding variable
                    setContentView (binding.root)
    }

}