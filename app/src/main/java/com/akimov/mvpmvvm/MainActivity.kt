package com.akimov.mvpmvvm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.akimov.mvpmvvm.databinding.MainActivityBinding
import com.akimov.mvpmvvm.mvp_screen.MvpActivity
import com.akimov.mvpmvvm.mvvm_screen.MvvmActivity

class MainActivity : AppCompatActivity() {
    private val binding by lazy { MainActivityBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.mvpButton.setOnClickListener {
            startActivity(Intent(this, MvpActivity::class.java))
        }

        binding.mvvmButton.setOnClickListener {
            startActivity(Intent(this, MvvmActivity::class.java))
        }
    }
}
