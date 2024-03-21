package com.akimov.mvpmvvm.mvvm_screen

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.akimov.mvpmvvm.R
import com.akimov.mvpmvvm.databinding.LoginScreenBinding
import kotlinx.coroutines.launch

class MvvmActivity : AppCompatActivity() {
    private val binding by lazy {
        LoginScreenBinding.inflate(layoutInflater)
    }
    private val viewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.isNumberSuccess.collect { isSuccess ->
                    when (isSuccess) {
                        true -> showSuccess()
                        false -> showError()
                        null -> Unit
                    }

                }
            }
        }

        binding.btn.setOnClickListener {
            viewModel.onLoginButtonClick(binding.phone.text.toString())
        }
    }

    private fun showError() {
        Toast.makeText(this, getString(R.string.mistake_in_phone_number), Toast.LENGTH_SHORT).show()
    }

    private fun showSuccess() {
        Toast.makeText(this, getString(R.string.success), Toast.LENGTH_SHORT).show()
    }
}
