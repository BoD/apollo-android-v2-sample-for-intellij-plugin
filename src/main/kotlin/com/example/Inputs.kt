package com.example

import com.apollographql.apollo.api.Input

fun main() {
    val present = Input.fromNullable("a")
    val absent = Input.absent<String>()
    val optional = Input.optional("a")
}