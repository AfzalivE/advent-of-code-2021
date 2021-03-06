plugins {
    kotlin("jvm")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom")) 

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8") 
}

tasks {
    sourceSets {
        main {
            java.srcDirs("src")
        }
    }
}

val day: String? by project

val runDay by tasks.registering(JavaExec::class) {
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("Day${day}Kt")
    setArgsString("Day$day")
}