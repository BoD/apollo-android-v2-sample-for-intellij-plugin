plugins {
    kotlin("jvm")
    id("com.apollographql.apollo")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.apollographql.apollo:apollo-runtime:2.5.11")
    implementation(project(":graphqlSchema"))
    apolloMetadata(project(":graphqlSchema"))
}

apollo {
    generateApolloMetadata.set(true)
    generateKotlinModels.set(true)

    service("service-a") {
        sourceFolder.set("com/example/servicea")
        rootPackageName.set("com.example.servicea")
    }

    service("service-b") {
        sourceFolder.set("com/example/serviceb")
        rootPackageName.set("com.example.serviceb")
    }
}
