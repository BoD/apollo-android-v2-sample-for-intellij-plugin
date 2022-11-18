plugins {
    kotlin("jvm")
    id("com.apollographql.apollo")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.apollographql.apollo:apollo-runtime:2.5.13")
    implementation("com.apollographql.apollo:apollo-coroutines-support:2.5.13")

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

tasks.register("printClasspath") {
    doLast {
        sourceSets["main"].runtimeClasspath.files.forEach { println(it) }
    }
}
