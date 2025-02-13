plugins {
    id("java")  // Apply the Java plugin for dependency management
}

repositories {
    mavenCentral()
    
}
dependencies {
// https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
implementation("org.seleniumhq.selenium:selenium-java:4.28.1")
// https://mvnrepository.com/artifact/org.testng/testng
testImplementation("org.testng:testng:7.10.2")
// https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
implementation("io.github.bonigarcia:webdrivermanager:5.9.2")



}