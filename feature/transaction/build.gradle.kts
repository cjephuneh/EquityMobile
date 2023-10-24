plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
    kotlin("plugin.serialization")
    id("kotlin-parcelize")

}

/*
apply {
    from("$rootDir/base-module.gradle")
}
*/

android {
    namespace = "com.dev.chacha.transaction"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    compileOptions {
        sourceCompatibility = AndroidConfig.javaVersion
        targetCompatibility = AndroidConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = AndroidConfig.jvmTarget
        freeCompilerArgs + "-Xjvm-default=all"

    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AndroidConfig.kotlinCompilerExtension
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            pickFirsts.add("META-INF/io.netty.versions.properties")
        }
    }


}

dependencies {
    implementation(project(Modules.ui))
    implementation(project(Modules.util))

    implementation(platform(libs.compose.bom))
    implementation(libs.android.coreKtx)
    implementation(libs.android.appCompat)
    implementation(libs.android.material)
    implementation(libs.accompanist.navigation)
    implementation(libs.biometric)
    implementation(libs.bundles.lifecycle)
    implementation(libs.datastore)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.accompanist)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.bundles.koin)
    api(libs.bundles.internal.camerax)
    implementation(libs.lifecycle.runtimeKtx)
    implementation(libs.timber)
    implementation(libs.androidx.splashscreen)
    implementation(libs.kotlin.coroutines.play.services)
    implementation(libs.gms.play.services.auth)
    implementation(libs.accompanist.flowlayout)
    implementation(libs.lottie.compose)
    implementation(libs.gson.gson)
    implementation(libs.coil.compose)
    implementation(libs.coil.gf)
    implementation(libs.timber)
    implementation(libs.accompanist.swiperefresh)
    implementation(libs.kotlin.coroutines.datetime)
    implementation(libs.zeko.query.builder)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)
    androidTestImplementation(libs.android.test.junit4)
    androidTestImplementation(libs.android.test.espresso)
    androidTestImplementation(libs.compose.ui.test.junit)
    testImplementation(libs.test.junit4)
    testImplementation(libs.test.robolectric)
    testImplementation(libs.compose.ui.test.junit)
    testImplementation(libs.android.test.espresso)
    testImplementation(libs.test.navigation)
    testImplementation(libs.test.mockk)


    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.android.hilt.navigation.compose)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.android.hilt.navigation.compose)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    kapt(libs.android.hilt.androidx.compiler)
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.android.compiler)

}

kotlin {
    sourceSets {
        all {
            languageSettings.apply {
                optIn("androidx.compose.material3.ExperimentalMaterial3Api")
            }
        }
    }
}