package com.example

import com.apollographql.apollo.api.FileUpload

suspend fun main() {
    val fileUpload = FileUpload("text/plain", "/etc/passwd")
}
