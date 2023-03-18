plugins {
    id("kotlin")
    id("groovy")
    id("java-gradle-plugin")
    id("maven-publish")
}

dependencies {
    // Gradle SDK
    implementation(gradleApi())
    // ASM
    compileOnly("commons-io:commons-io:2.6")
    compileOnly("commons-codec:commons-codec:1.15")
    compileOnly("org.ow2.asm:asm-tree:9.3")
    compileOnly("org.ow2.asm:asm-commons:9.3")
    compileOnly("commons-io:commons-io:2.6")
    // Transform Api
    implementation("com.android.tools.build:gradle:7.2.0")
    implementation("com.android.tools.build:gradle-api:7.3.1")
    // 启用Kotlin
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin-api:1.8.0")
}

gradlePlugin {
    plugins {
        create("project") {
            id = "com.silvertip.meta"
            implementationClass = "com.silvertip.meta.ClickPlugin"
        }
    }
}

publishing {
    repositories {
        maven("../repo")
    }
    publications {
        create<MavenPublication>("project") {
            from(components["java"])
            groupId = "com.silvertip.meta"
            artifactId = "clickPlugin"
            version = "1.0.0"
        }
    }
}