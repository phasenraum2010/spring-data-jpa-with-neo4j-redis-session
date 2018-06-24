#!/usr/bin/env bash

source bin/run-config.sh

mvn -N io.takari:maven:wrapper -Dmaven=$MAVEN_VERSION

