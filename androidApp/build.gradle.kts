plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "com.okankkl.moviekmm.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.okankkl.moviekmm.android"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.compose.ui.tooling)


    implementation("io.insert-koin:koin-androidx-compose:${libs.versions.koinComposeVersion.get()}")
    implementation("io.coil-kt:coil-compose:${libs.versions.coilVersion.get()}")
    implementation("com.google.accompanist:accompanist-systemuicontroller:${libs.versions.accompanistVersion.get()}")
    implementation("androidx.navigation:navigation-compose:${libs.versions.navVersion}")
    implementation ("androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01")
    implementation ("androidx.compose.material:material:1.6.5")
    //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")



}