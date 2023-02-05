pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        maven { url = uri("https://jitpack.io") }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        google()
        maven { url = uri("https://jitpack.io") }
    }
}


rootProject.name = "EquityMobile"
include(":app")
include (":feature:auth")
include (":feature:transaction")
include (":feature:loans")
include (":feature:home")
include (":feature:savings")
include (":data")
include (":domain")
include(":core:ui")
include(":core:util")
include(":core-database")
include(":core-network")
include(":feature:more")
include(":feature:onboarding")
include(":common")
