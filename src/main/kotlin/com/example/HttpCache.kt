package com.example

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.cache.http.ApolloHttpCache
import com.apollographql.apollo.cache.http.DiskLruHttpCacheStore
import com.apollographql.apollo.cache.http.internal.FileSystem
import java.io.File

suspend fun main() {
    val maxSize = 10000L
    val diskLruHttpCacheStore1 = DiskLruHttpCacheStore(File(""), maxSize)
    val apolloHttpCache1 = ApolloHttpCache(diskLruHttpCacheStore1)

    val diskLruHttpCacheStore2 = DiskLruHttpCacheStore(FileSystem.SYSTEM, File(""), maxSize)
    val apolloHttpCache2 = ApolloHttpCache(diskLruHttpCacheStore1)

    val apolloClient = ApolloClient.builder()
        .httpCache(apolloHttpCache1)
        .build()
}
