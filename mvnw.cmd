@echo off
setlocal
set MVN_VERSION=3.9.4
set BASE_DIR=%~dp0
set MAVEN_DIR=%BASE_DIR%\.mvn\wrapper
set JAR=%MAVEN_DIR%\maven-wrapper.jar
set PROPERTIES=%MAVEN_DIR%\maven-wrapper.properties
java -jar "%JAR%" %*
