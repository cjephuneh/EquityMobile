import org.gradle.api.JavaVersion

object AndroidConfig {
    const val minSdk = 24
    const val targetSdk = 34
    const val compileSdk = 34
    const val versionCode = 1
    const val versionName = "1.0"
    const val applicationId = "com.chachadeveloper.equitymobile"
    const val kotlinCompilerExtension = "1.4.3"


    val javaVersion = JavaVersion.VERSION_17
    const val jvmTarget = "17"

}