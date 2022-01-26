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

    implementation(project(":feature1"))
    apolloMetadata(project(":feature1"))

}

apollo {
//    generateKotlinModels.set(true)

    service("service-a") {}
    service("service-b") {}
}
