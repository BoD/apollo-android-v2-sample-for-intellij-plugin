package com.example.myapplication.apolloplugintests

import com.apollographql.apollo.ApolloClient

suspend fun main() {
    val apolloClient: ApolloClient? = null
    apolloClient!!.clearNormalizedCache()
    apolloClient.clearHttpCache()
}
