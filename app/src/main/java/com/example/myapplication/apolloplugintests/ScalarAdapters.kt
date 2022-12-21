package com.example.myapplication.apolloplugintests

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.CustomTypeAdapter
import com.apollographql.apollo.api.CustomTypeValue
import com.example.type.CustomType
import java.net.URL
import java.util.*

suspend fun main() {
    val apolloClient = ApolloClient.builder()
        .addCustomTypeAdapter(CustomType.DATETIME, DateTimeAdapter())
        .addCustomTypeAdapter(CustomType.URL, UrlAdapter())
        .build()
}

class DateTimeAdapter : CustomTypeAdapter<Date> {
    override fun decode(value: CustomTypeValue<*>): Date {
        TODO("Not yet implemented")
    }

    override fun encode(value: Date): CustomTypeValue<*> {
        TODO("Not yet implemented")
    }
}

class UrlAdapter : CustomTypeAdapter<URL> {
    override fun decode(value: CustomTypeValue<*>): URL {
        TODO("Not yet implemented")
    }

    override fun encode(value: URL): CustomTypeValue<*> {
        TODO("Not yet implemented")
    }
}
