package com.example

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.cache.normalized.sql.SqlNormalizedCacheFactory

suspend fun main() {
    val dbName = "apollo.db"
    val cacheFactory1 = SqlNormalizedCacheFactory(context, "apollo.db")
    val cacheFactory2 = SqlNormalizedCacheFactory(context, dbName)
    val apolloClient = ApolloClient.builder()
        .normalizedCache(cacheFactory1)
        .build()
}
