plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.jobamate"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.jobamate"
        minSdk = 34
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
    }

}

dependencies {



    // inputan tambahan buat kebutuhan

    implementation("androidx.recyclerview:recyclerview:1.2.1") //inputan recylerview
    implementation("androidx.viewpager2:viewpager2:1.0.0") //inputan view pager
    implementation("me.relex:circleindicator:2.1.6") //inputan material circle indicator
    implementation("com.google.android.material:material:1.7.0") //inputan material desain
    implementation("com.google.android.material:material:1.9.0") //inputan material desain
    implementation("com.klinkerapps:link_builder:2.0.5") //inputan untuk linktext

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")


    // inputan asli dari awal
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}