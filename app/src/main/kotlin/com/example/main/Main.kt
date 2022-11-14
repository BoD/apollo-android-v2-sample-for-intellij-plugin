package com.example.main

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.example.servicea.ServiceAMutation1Mutation
import com.example.servicea.ServiceAQuery1Query
import com.example.servicea.ServiceAQuery2Query
import com.example.serviceb.ServiceBQuery1Query
import com.example.serviceb.ServiceBQuery2Query

suspend fun main() {
    ServiceAQuery1Query()
    ServiceAQuery2Query()

    ServiceBQuery1Query()
    ServiceBQuery2Query()

    val apolloClient = ApolloClient.builder()
        .serverUrl("http://example.com")
        .build()

    val response: Response<ServiceAMutation1Mutation.Data> = apolloClient.mutate(ServiceAMutation1Mutation()).await()
    println(response.data)
}
