package com.akimov.mvpmvvm.mvp_screen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.akimov.mvpmvvm.R
import com.akimov.mvpmvvm.databinding.LoginScreenBinding

class MvpActivity: AppCompatActivity(), MvpView {
    private val binding by lazy {
        LoginScreenBinding.inflate(layoutInflater)
    }
    private val presenter by lazy { Presenter(view = this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btn.setOnClickListener {
            presenter.validatePhoneNumber(binding.phone.text.toString())
        }
    }

    override fun showSuccess() {
        Toast.makeText(this, getString(R.string.success), Toast.LENGTH_SHORT).show()
    }

    override fun showError() {
        Toast.makeText(this, getString(R.string.mistake_in_phone_number), Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        presenter.removeView()
        super.onDestroy()
    }
}