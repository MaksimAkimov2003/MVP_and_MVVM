package com.akimov.mvpmvvm

class Validator {
    companion object {
        private const val pattern = """^\+7 \(\d{3}\) \d{3} \d{2} \d{2}$"""
    }

    fun checkIsPhoneNumberValid(value: String) = pattern.toRegex().matches(value)
}