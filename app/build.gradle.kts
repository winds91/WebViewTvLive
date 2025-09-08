plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.vasthread.webviewtv"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.vasthread.webviewtv"
        minSdk = 19
        targetSdk = 36
        versionCode = 6
        versionName = "1.6"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        ndk {
            //abiFilters += listOf("arm64-v8a")
            abiFilters += listOf("arm64-v8a","armeabi-v7a","x86_64","x86")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    applicationVariants.all {
        outputs.all {
            val output = this as com.android.build.gradle.internal.api.BaseVariantOutputImpl
            output.outputFileName = if (buildType.name == "release") {
                "WebViewTV.apk"
            } else {
                "WebViewTV_debug.apk"
            }
        }
    }

}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.preference:preference-ktx:1.2.1")
    implementation("com.tencent.tbs:tbssdk:44286")
    implementation("com.tencent.bugly:crashreport:latest.release")
    implementation("com.github.JessYanCoding:AndroidAutoSize:v1.2.1")
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("com.squareup.okhttp3:okhttp:3.12.13")
    implementation("org.apache.commons:commons-lang3:3.0")
}