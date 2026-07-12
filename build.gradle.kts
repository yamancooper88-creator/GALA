plugins {
    id("com.android.application") version "8.2.0"
    kotlin("android") version "1.9.10"
    kotlin("kapt") version "1.9.10"
    id("com.google.dagger.hilt.android") version "2.48"
}

android {
    namespace = "com.ohatv.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ohatv.app"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        // Zwingend: armeabi-v7a für Nokia Streaming Box 8010
        ndk {
            abiFilters.add("armeabi-v7a")
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Android Core
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")

    // Jetpack Compose for TV
    implementation("androidx.tv:tv-foundation:1.0.0-alpha10")
    implementation("androidx.tv:tv-material:1.0.0-alpha10")
    implementation("androidx.compose.ui:ui:1.6.0")
    implementation("androidx.compose.material:material:1.6.0")
    implementation("androidx.compose.foundation:foundation:1.6.0")
    implementation("androidx.compose.runtime:runtime:1.6.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")

    // Media3 / ExoPlayer
    implementation("androidx.media3:media3-exoplayer:1.1.1")
    implementation("androidx.media3:media3-ui:1.1.1")
    implementation("androidx.media3:media3-common:1.1.1")
    implementation("androidx.media3:media3-datasource-okhttp:1.1.1")

    // Networking
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.retrofit2:retrofit:2.10.0")
    implementation("com.squareup.retrofit2:converter-kotlinx-serialization:2.10.0")

    // JSON Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

    // HTML Parsing
    implementation("org.jsoup:jsoup:1.16.1")

    // Local Data
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")

    // DataStore
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    // Dependency Injection (Hilt)
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-compiler:2.48")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    // Logging
    implementation("com.jakewharton.timber:timber:5.0.1")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
