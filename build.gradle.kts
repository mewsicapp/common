import org.jetbrains.kotlin.konan.properties.hasProperty
import java.io.File
import java.io.FileInputStream
import java.util.*
plugins {
    kotlin("multiplatform") version "1.7.0"
    id("com.android.library") version "7.0.3"
    kotlin("plugin.serialization") version "1.6.10"
    id("com.github.ben-manes.versions") version "0.42.0"
    id("se.patrikerdes.use-latest-versions") version "0.2.18"
    `maven-publish`
}

group = "com.mewsic"
version = "1.0-SNAPSHOT"
val prop = Properties().apply {
    load(FileInputStream(File(rootProject.rootDir, "local.properties")))
}
repositories {
    google()
    jcenter()
    mavenCentral()
    // kotlin EAP
    maven {
        url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
    }
    // ktor EAP
    maven {
        url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
    }
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js("chrome", BOTH) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }


    android()
    js("node", IR) {
        binaries.executable()
        nodejs {

        }
    }
    sourceSets {
        val ktorVersion = "2.0.3"
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.3")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
            }

        }
        val jvmTest by getting
        val chromeMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-js:$ktorVersion")
                implementation(npm("@js-joda/timezone", "2.3.0"))
            }
        }
        val chromeTest by getting
        val nativeMain by getting {
            dependencies {
                if (hostOs == "Mac OS X") {
                    implementation("io.ktor:ktor-client-darwin:$ktorVersion")
                } else {
                    implementation("io.ktor:ktor-client-cio:$ktorVersion")
                }
            }
        }
        val nativeTest by getting
        val androidMain by getting {
            dependencies {
                implementation("com.google.android.material:material:1.6.1")
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13.2")
            }
        }
        val nodeMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-nodejs:0.0.7")
                implementation("io.ktor:ktor-client-js:$ktorVersion")
                implementation(npm("@js-joda/timezone", "2.3.0"))

            }
        }
        val nodeTest by getting
        // soonTM
//        val iosMain by creating {
//            dependsOn(commonMain)
//            iosX64Main.dependsOn(this)
//            iosArm64Main.dependsOn(this)
//            iosSimulatorArm64Main.dependsOn(this)
//            dependencies {
//                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
//            }
//        }
    }
}

android {
    compileSdkVersion(32)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
//        applicationId = "com.mewsic.library"
        minSdkVersion(24)
        targetSdkVersion(32)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
// KotlinNative New MM
kotlin.targets.withType(org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget::class.java) {
    binaries.all {
        binaryOptions["memoryModel"] = "experimental"
    }
}

if (prop.hasProperty("mavenToken")) {
    // push to maven repo
    publishing {
        repositories {
            maven {
                name = "Host"
                url = uri("https://maven.martmists.com/releases")
                credentials {
                    username = "mewsic"
                    password = prop.getProperty("mavenToken")
                }
            }
        }
    }
}
tasks {
    named("publish") {
        dependsOn("build")
    }
}