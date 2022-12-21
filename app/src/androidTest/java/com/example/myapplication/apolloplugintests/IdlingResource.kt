package com.example.myapplication.apolloplugintests

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.test.espresso.ApolloIdlingResource

suspend fun main() {
    val apolloClient: ApolloClient? = null
    val idlingResource = ApolloIdlingResource.create("ApolloIdlingResource", apolloClient!!)
}
