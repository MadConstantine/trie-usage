plugins {
    // Apply the java plugin to add support for Java
    java

    // Apply the application plugin to add support for building a CLI application.
    application

}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:4.13")
}

application {
    // Define the main class for the application.
    mainClassName = "com.constantine.App"
}

tasks.jar{
    manifest {
        attributes["Main-Class"] = "com.constantine.App"
    }
}