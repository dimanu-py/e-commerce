plugins {
    java
    id("org.springframework.boot") version "3.4.0"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "dimanu"
version = "0.0.1-SNAPSHOT"

allprojects {
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")

    repositories {
        mavenCentral()
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_23
        targetCompatibility = JavaVersion.VERSION_23
    }

    dependencies {
        // Prod
        implementation("javax.xml.bind:jaxb-api:2.4.0-b180830.0359")
        implementation("com.sun.xml.bind:jaxb-impl:4.0.5")
        implementation("org.apache.tomcat:tomcat-dbcp:10.1.25")
        implementation("org.springframework:spring-orm:6.1.10")
        implementation("org.hibernate.orm:hibernate-core:6.5.2.Final")
        compileOnly("org.projectlombok:lombok:1.18.34")
        annotationProcessor("org.projectlombok:lombok:1.18.34")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("mysql:mysql-connector-java:8.0.33")

        // Test
        testImplementation("io.rest-assured:rest-assured:5.4.0")
        testImplementation("io.rest-assured:rest-assured-common:5.4.0")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
        testImplementation("org.yaml:snakeyaml:1.24")
        testImplementation("com.github.javafaker:javafaker:1.0.2")
    }

    tasks.withType<Test> {
        useJUnitPlatform()

        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}

dependencies {
    implementation(project(":backoffice"))
    implementation(project(":shared"))
}

sourceSets {
    main {
        java.setSrcDirs(listOf("app/main"))
        resources.setSrcDirs(listOf("app/main/resources"))
    }

    test {
        java.setSrcDirs(listOf("app/test"))
        resources.setSrcDirs(listOf("app/test/resources"))
    }
}

subprojects {

    sourceSets {
        main {
            java.setSrcDirs(listOf("main"))
            resources.setSrcDirs(listOf("main/resources"))
        }

        test {
            java.setSrcDirs(listOf("test"))
            resources.setSrcDirs(listOf("test/resources"))
        }
    }

    dependencies {
        testImplementation(rootProject.sourceSets["main"].output)
        if (project.name != "shared"){
            implementation(project(":shared"))
            testImplementation(project(":shared", "testArtifacts"))
        }
    }
}
