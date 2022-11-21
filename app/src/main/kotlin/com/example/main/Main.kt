package com.example.main

import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.ApolloMutationCall
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

    val y = apolloClient.mutate(ServiceAMutation1Mutation())
    y.await()

    val x : ApolloMutationCall<Unit>? =null
    x!!.await()

    val response: Response<ServiceAMutation1Mutation.Data> = apolloClient.mutate(ServiceAMutation1Mutation()).await()
    apolloClient.mutate(ServiceAMutation1Mutation()).await()

    val response2: com.apollographql.apollo.api.Response<ServiceAMutation1Mutation.Data> = apolloClient.mutate(ServiceAMutation1Mutation()).await()


    println(response.data)
}
