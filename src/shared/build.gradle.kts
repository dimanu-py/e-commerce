val testArtifacts by configurations.creating {
    extendsFrom(configurations["testImplementation"])
}

val testJar by tasks.registering(Jar::class) {
    archiveClassifier.set("tests")
    from(sourceSets["test"].output)
}

artifacts {
    add("testArtifacts", testJar)
}



