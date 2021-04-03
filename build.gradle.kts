plugins {
    kotlin("multiplatform") version "1.4.10"
}
group = "brymher.gmail.com"

repositories {
    mavenCentral()
}

kotlin {
    // For ARM, preset function should be changed to iosArm32() or iosArm64()
    // For Linux, preset function should be changed to e.g. linuxX64()
    // For MacOS, preset function should be changed to e.g. macosX64()
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")

    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("Unify")
        hostOs == "Linux" -> linuxX64("Unify")
        isMingwX64 -> mingwX64("Unify")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }


    nativeTarget.apply {
        binaries {
            executable {
                entryPoint = "unify.main"
            }
        }
    }


    sourceSets {
        @Suppress("LocalVariableName") val UnifyMain by getting
        @Suppress("LocalVariableName") val UnifyTest by getting
    }

}

dependencies {


}

// Use the following Gradle tasks to run your application:
// :runHelloWorldAppReleaseExecutableHelloWorld - without debug symbols
// :runHelloWorldAppDebugExecutableHelloWorld - with debug symbols
