plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.developerssays.uitask"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.developerssays.uitask"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //
    dependencies {

        dependencies {
            // Jetpack Compose dependencies
            //   implementation "androidx.compose.ui:ui:$compose_version"
            // implementation "androidx.compose.material3:material3:$compose_version"
            //   implementation "androidx.compose.ui:ui-tooling-preview:$compose_version"
            //  implementation "androidx.compose.runtime:runtime-livedata:$compose_version"  // For LiveData integration
            //   implementation "androidx.compose.runtime:runtime:$compose_version" // For StateFlow integration
            //  implementation "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version" // For ViewModel with Compose
            // }


            // Jetpack Compose dependencies
            implementation("androidx.compose.ui:ui:1.5.0")// Replace with the latest version
            implementation("androidx.compose.material3:material3:1.0.0") // Replace with the latest version
            implementation("androidx.compose.runtime:runtime-livedata:1.5.0") // For ViewModel support

            // ViewModel dependencies
            implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1") // For integration with Compose
            implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1") // Lifecycle support


            val nav_version = "2.8.5"

            implementation("androidx.navigation:navigation-compose:$nav_version")

            implementation ("com.google.code.gson:gson:2.8.8")



            implementation("androidx.compose.material:material-icons-extended:1.7.6") // Latest version at time of writing


            // Other dependencies
            //  implementation "androidx.activity:activity-compose:1.7.0" // For integrating Compose with Activities

        }
    }
}