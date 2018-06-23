#!/usr/bin/env bash

export JAVA_OPTIONS_HEROKU='-Xmx350m -Xss512k -Dfile.encoding=UTF-8'
export JAVA_OPTIONS='-Xmx300m -Xss512k -Dfile.encoding=UTF-8'
export MAVEN_OPTS="-Xmx512m"
export SERVER_PORT=8080

export MAVEN_VERSION=3.5.3

export PROFILES="developmentembedded developmentlocalhost"

function verify(){
    ./mvnw -e verify
}

function run() {
    PROFILE=$1
    ./mvnw -e -P$PROFILE -Dspring.profiles.active=$PROFILE clean spring-boot:run
}

function run_like_heroku() {
    PROFILE=$1
    java -P$PROFILE -Dspring.profiles.active=$PROFILE -Dserver.port=$PORT $JAVA_OPTIONS -jar target/combined-databases-1.0.1-SNAPSHOT.jar
}

function build(){
    verify
    ./mvnw -e clean install dependency:tree
}

function site(){
    PROFILE=$1
    verify
    ./mvnw -e -P$PROFILE -Dspring.profiles.active=$PROFILE -Dserver.port=$PORT clean install dependency:tree site
}

function site_run(){
    PROFILE=$1
    verify
    ./mvnw -e -P$PROFILE -Dspring.profiles.active=$PROFILE -Dserver.port=$PORT clean install dependency:tree site site:run
}


