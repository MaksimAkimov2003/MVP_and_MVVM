package com.akimov.mvpmvvm.mvvm_screen

import androidx.lifecycle.ViewModel
import com.akimov.mvpmvvm.Validator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyViewModel(
    private val validator: Validator = Validator()
): ViewModel() {
    private val _isNumberSuccess: MutableStateFlow<Boolean?> = MutableStateFlow(null)
    val isNumberSuccess = _isNumberSuccess.asStateFlow()

    fun onLoginButtonClick(phone: String) {
        _isNumberSuccess.update {
            validator.checkIsPhoneNumberValid(phone)
        }
    }
}