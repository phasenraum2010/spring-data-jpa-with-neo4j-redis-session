#!/usr/bin/env bash

export PORT=8080
export JAVA_OPTIONS='-Xmx350m -Xss512k -Dfile.encoding=UTF-8'
export MAVEN_OPTS="-Xmx512m"
export PROFILE=development

./mvnw clean install


