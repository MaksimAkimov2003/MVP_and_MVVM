package com.akimov.mvpmvvm.mvp_screen

import com.akimov.mvpmvvm.Validator

class Presenter(
    private val validator: Validator = Validator(),
    private var view: MvpView?
) {

    fun validatePhoneNumber(value: String) {
        if (validator.checkIsPhoneNumberValid(value)) {
            view?.showSuccess()
        } else {
            view?.showError()
        }
    }

    fun removeView() {
        view = null
    }
}