#!/usr/bin/env bash

source bin/run-config.sh

export PORT=8080
export JAVA_OPTIONS='-Xmx350m -Xss512k -Dfile.encoding=UTF-8'
export MAVEN_OPTS="-Xmx512m"
export PROFILE=developmentlocalhost

./mvnw clean install


