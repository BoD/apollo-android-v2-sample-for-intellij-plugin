package com.example

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.ApolloMutationCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.cache.http.HttpCachePolicy
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.fetcher.ApolloResponseFetchers

suspend fun main() {
    val apolloClient = ApolloClient.builder()
        .serverUrl("http://example.com")
        .build()

    val call: ApolloMutationCall<MyMutation1Mutation.Data> = apolloClient.mutate(MyMutation1Mutation())
    val response: Response<MyMutation1Mutation.Data> = call.await()

    apolloClient
        .query(MyQuery1Query())
        .toBuilder()
        .httpCachePolicy(HttpCachePolicy.NETWORK_ONLY)
        .responseFetcher(ApolloResponseFetchers.NETWORK_ONLY)
        .build()

    println(response.data)

    println(MyMutation1Mutation.OPERATION_NAME.name())
}
