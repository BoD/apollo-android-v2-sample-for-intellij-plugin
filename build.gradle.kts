plugins {
    java
    kotlin("jvm") version "1.6.10"
    id("com.apollographql.apollo") version "2.5.14"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.apollographql.apollo:apollo-runtime:2.5.14")
    implementation("com.apollographql.apollo:apollo-coroutines-support:2.5.14")
    implementation("com.apollographql.apollo:apollo-normalized-cache:2.5.14")
    implementation("com.apollographql.apollo:apollo-http-cache:2.5.14")
}

apollo {
    // packageName.set("com.example")
    generateKotlinModels.set(true)
}

tasks.register("printClasspath") {
    doLast {
        sourceSets["main"].runtimeClasspath.files.forEach { println(it) }
    }
}
