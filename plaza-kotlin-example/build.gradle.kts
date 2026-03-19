plugins {
    id("plaza.kotlin")
    application
}

dependencies {
    implementation(project(":plaza-kotlin-core"))
    implementation(project(":plaza-kotlin-client-okhttp"))
}

application {
    // Use `./gradlew :plaza-kotlin-example:run` to run `Main`
    // Use `./gradlew :plaza-kotlin-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.plazafyi.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}ExampleKt"
        else
            "MainKt"
    }"
}
