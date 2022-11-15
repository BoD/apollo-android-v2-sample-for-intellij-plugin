package com.example.javamain;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.ApolloMutationCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.servicea.ServiceAMutation1Mutation;
import org.jetbrains.annotations.NotNull;

public class JavaMain {
    public static void main(String[] av) {
        ApolloClient apolloClient = ApolloClient.builder()
                .serverUrl("https://example.com")
                .build();

        ApolloMutationCall<ServiceAMutation1Mutation.Data> call = apolloClient.mutate(new ServiceAMutation1Mutation());
        call.enqueue(new ApolloCall.Callback<>() {
            @Override
            public void onResponse(@NotNull Response<ServiceAMutation1Mutation.Data> response) {
                System.out.println(response.getData());
            }

            @Override
            public void onFailure(@NotNull ApolloException e) {
                e.printStackTrace();
            }
        });
    }
}
