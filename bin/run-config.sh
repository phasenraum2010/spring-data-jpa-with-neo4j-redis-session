#!/usr/bin/env bash

export JAVA_OPTIONS_HEROKU='-Xmx350m -Xss512k -Dfile.encoding=UTF-8'
export JAVA_OPTIONS='-Xmx300m -Xss512k -Dfile.encoding=UTF-8'
export MAVEN_OPTS="-Xmx512m"
export SERVER_PORT=8080

export MAVEN_VERSION=3.5.3

application-integrationlocalhost.yml
application-integrationtravisci.yml
application-testinglocalhost.yml
application-productionlocalhost.yml

export PROFILES="default developmentembedded developmentlocalhost integrationlocalhost integrationtravisci testinglocalhost productionlocalhost"

function verify(){
    ./mvnw -e verify
}

function run() {
    PROFILE=$1
    ./mvnw -e -P$PROFILE verify
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

function build_profile (){
    PROFILE=$1
    ./mvnw -e -P$PROFILE verify
    ./mvnw -e -P$PROFILE clean install dependency:tree
}

function site(){
    PROFILE=$1
    verify
    ./mvnw -e -P$PROFILE -Dspring.profiles.active=$PROFILE -Dserver.port=$PORT clean install dependency:tree site
}

function site_run(){
    PROFILE=$1
    ./mvnw -e -P$PROFILE verify
    ./mvnw -e -P$PROFILE -Dspring.profiles.active=$PROFILE -Dserver.port=$PORT clean install dependency:tree site site:run
}

function build_all_profiles(){
    for PROFILE in $PROFILES
    do
        build_profile $PROFILE
    done
}

function run_all_profiles(){
    for PROFILE in $PROFILES
    do
        run $PROFILE
    done
}

function run_like_heroku_all_profiles(){
    for PROFILE in $PROFILES
    do
        run_like_heroku $PROFILE
    done
}

function site_all_profiles(){
    for PROFILE in $PROFILES
    do
        site $PROFILE
    done
}

function test_all_profiles(){
    build_all_profiles
    run_all_profiles
    run_like_heroku_all_profiles
    site_all_profiles
}


