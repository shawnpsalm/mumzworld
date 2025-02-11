plugins {
    id("java")  // Apply the Java plugin for dependency management
}

repositories {
    mavenCentral()
    jcenter()  // Optional, some older versions may require this
}
dependencies {
// https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
implementation("org.seleniumhq.selenium:selenium-java:4.28.1")
// https://mvnrepository.com/artifact/org.testng/testng
testImplementation("org.testng:testng:7.10.2")


}