plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("org.jlleitschuh.gradle.ktlint")
    id("io.gitlab.arturbosch.detekt")

    kotlin("kapt")
}

android {
    namespace = AndroidConfig.applicationId
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        testInstrumentationRunner= "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary =true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = AndroidConfig.javaVersion
        targetCompatibility = AndroidConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = AndroidConfig.jvmTarget
    }
    buildFeatures {
        compose = true
        viewBinding = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AndroidConfig.kotlinCompilerExtension
    }
    packaging {
        resources {
            pickFirsts.add("META-INF/io.netty.versions.properties")
            pickFirsts.add("META-INF/INDEX.LIST")
        }
    }
}

dependencies {
    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    implementation(project(Modules.ui))
    implementation(project(Modules.util))

    implementation(project(Modules.coreNetwork))
    implementation(project(Modules.coreDatabase))

    implementation(project(Modules.home))
    implementation(project(Modules.transaction))
    implementation(project(Modules.loans))
    implementation(project(Modules.savings))
    implementation(project(Modules.auth))
    implementation(project(Modules.more))
    implementation(project(Modules.onboarding))

    implementation(platform(libs.compose.bom))
    implementation(libs.datastore)
    implementation(libs.androidx.splashscreen)
    implementation(libs.android.coreKtx)
    implementation(libs.android.appCompat)
    implementation(libs.android.material)
    implementation(libs.timber)
    implementation(libs.accompanist.navigation)
    implementation(libs.accompanist.swiperefresh)
    implementation(libs.accompanist.animation)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.accompanist)
    implementation(libs.easycrop)
    implementation(libs.androidx.junit.ktx)
    testImplementation(libs.test.junit4)

    androidTestImplementation("androidx.test.ext:junit:1.1.2")


     implementation("com.google.dagger:dagger:2.46.1")
     kapt("com.google.dagger:dagger-compiler:2.46.1")
     implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
     implementation("com.google.dagger:hilt-android:2.46.1")
     kapt("com.google.dagger:hilt-android-compiler:2.46.1")
     kapt("androidx.hilt:hilt-compiler:1.0.0")
     androidTestImplementation("com.google.dagger:hilt-android-testing:2.46.1")
     kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.46.1")


}

kotlin {
    sourceSets {
        all {
            languageSettings.apply {
                optIn("androidx.compose.material3.ExperimentalMaterial3Api")
                optIn("androidx.compose.material.ExperimentalMaterialApi")
                optIn("androidx.compose.ui.ExperimentalComposeUiApi")
                optIn("androidx.compose.material.ExperimentalMaterialApi")
            }
        }
    }
}