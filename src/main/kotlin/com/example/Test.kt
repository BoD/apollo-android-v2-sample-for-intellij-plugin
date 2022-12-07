package com.example

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Subscription
import com.apollographql.apollo.coroutines.toFlow

suspend fun main() {
    val apolloClient: ApolloClient? = null
    val myQuery: Query<*, *, *>? = null
    val flow = apolloClient!!.query(myQuery!!)
        .watcher()
        .toFlow()

    val mySubscription: Subscription<*, *, *>? = null
    apolloClient.subscribe(mySubscription!!).toFlow()

}
