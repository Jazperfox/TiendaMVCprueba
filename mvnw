#!/bin/sh
# ----------------------------------------------------------------------------
# Maven Wrapper
# ----------------------------------------------------------------------------
MVN_VERSION="3.9.4"
BASE_DIR=$(cd "$(dirname "$0")"; pwd)
MAVEN_DIR="$BASE_DIR/.mvn/wrapper"
JAR="$MAVEN_DIR/maven-wrapper.jar"
PROPERTIES="$MAVEN_DIR/maven-wrapper.properties"
java -jar "$JAR" "$@"
