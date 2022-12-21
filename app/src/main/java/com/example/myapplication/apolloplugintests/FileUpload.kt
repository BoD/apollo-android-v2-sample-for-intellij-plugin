package com.example.myapplication.apolloplugintests

import com.apollographql.apollo.api.FileUpload

suspend fun main() {
    val fileUpload = FileUpload("text/plain", "/etc/passwd")
}
