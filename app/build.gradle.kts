plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.apollographql.apollo").version("2.5.14")
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")

    // Apollo
    implementation("com.apollographql.apollo:apollo-runtime:2.5.14")
    implementation("com.apollographql.apollo:apollo-coroutines-support:2.5.14")
    implementation("com.apollographql.apollo:apollo-normalized-cache:2.5.14")
    implementation("com.apollographql.apollo:apollo-normalized-cache-sqlite:2.5.14")
    implementation("com.apollographql.apollo:apollo-http-cache:2.5.14")
    implementation("com.apollographql.apollo:apollo-idling-resource:2.5.14")
}

apollo {
    // packageName.set("com.example")
    generateKotlinModels.set(true)
}
