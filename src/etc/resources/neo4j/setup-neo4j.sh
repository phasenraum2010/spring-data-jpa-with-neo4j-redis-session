#!/usr/bin/env bash

export JAVA_OPTIONS='-Xmx350m -Xss512k -Dfile.encoding=UTF-8'
export MAVEN_OPTS="-Xmx512m"
export BUILD_FAST=false

cd ~
mkdir -p j/neo4j
cd j/neo4j
wget https://github.com/neo4j/neo4j/archive/3.1.9.tar.gz
tar xvfz 3.1.9.tar.gz
cd neo4j-3.1.9
if [ "$BUILD_FAST" == "true" ]
then
    echo "BUILD_FAST"
    mvn clean install -DminimalBuild -DskipTests
    cd community/server
    mvn clean compile exec:java
else
    echo "BUILD_ALL"
    mvn clean install -DskipTests
    cd packaging/standalone/target
    tar xvfz neo4j-community-3.1.9-SNAPSHOT-unix.tar.gz
    cd neo4j-community-3.1.9-SNAPSHOT
    bin/neo4j start
    tail -f ../logs/neo4j.log
fi


