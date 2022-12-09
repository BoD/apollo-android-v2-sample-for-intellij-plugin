package com.example

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.cache.normalized.lru.EvictionPolicy
import com.apollographql.apollo.cache.normalized.lru.LruNormalizedCacheFactory

suspend fun main() {
    val cacheFactory = LruNormalizedCacheFactory(
        evictionPolicy = EvictionPolicy.builder().maxSizeBytes(10 * 1024 * 1024).build()
    )

    val apolloClient = ApolloClient.builder()
        .normalizedCache(cacheFactory)
        .build()
}
