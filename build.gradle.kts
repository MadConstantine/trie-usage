plugins {
    java
    application

}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:4.13")
}

application {
    mainClassName = "com.constantine.App"
}

tasks.jar{
    manifest {
        attributes["Main-Class"] = "com.constantine.App"
    }
}