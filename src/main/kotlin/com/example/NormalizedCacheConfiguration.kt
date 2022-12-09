package com.example

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.cache.normalized.lru.EvictionPolicy
import com.apollographql.apollo.cache.normalized.lru.LruNormalizedCacheFactory
import java.util.concurrent.TimeUnit

suspend fun main() {
    val cacheFactory1 = LruNormalizedCacheFactory(
        evictionPolicy = EvictionPolicy.builder().maxSizeBytes(10 * 1024 * 1024).build()
    )
    val cacheFactory2 = LruNormalizedCacheFactory(
        EvictionPolicy.builder().maxSizeBytes(10 * 1024 * 1024).build()
    )
    val cacheFactory3 = LruNormalizedCacheFactory(
        EvictionPolicy.builder()
            .maxSizeBytes(10 * 1024 * 1024)
            .expireAfterWrite(10, TimeUnit.MILLISECONDS)
            .build()
    )
    val cacheFactory4 = LruNormalizedCacheFactory(
        EvictionPolicy.builder()
            .maxSizeBytes(10 * 1024 * 1024)
            .expireAfterWrite(10, TimeUnit.MILLISECONDS)
            .expireAfterAccess(10, TimeUnit.MILLISECONDS)
            .maxEntries(42)
            .build()
    )

    val apolloClient = ApolloClient.builder()
        .normalizedCache(cacheFactory1)
        .normalizedCache(cacheFactory2)
        .normalizedCache(cacheFactory3)
        .normalizedCache(cacheFactory4)
        .build()
}
