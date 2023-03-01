package com.example.sqlitelearnone

import android.text.Editable

data class CustomerModel(
    val id: Int,
    val name: String,
    val age: Editable
)