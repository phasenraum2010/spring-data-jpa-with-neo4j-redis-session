#!/usr/bin/env bash

source bin/run-config.sh

mvn -N io.takari:maven:wrappers -Dmaven=$MAVEN_VERSION

