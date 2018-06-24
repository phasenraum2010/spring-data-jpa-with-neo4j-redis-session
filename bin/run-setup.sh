#!/usr/bin/env bash

source bin/run-config.sh

function run_maven_for_setup(){
    verify
    ./mvnw -e clean install -P setup
}

run_maven_for_setup


