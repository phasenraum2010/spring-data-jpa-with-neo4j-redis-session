#!/usr/bin/env bash

source run-config.sh

function qa_before_release_for_one_profile(){
    PROFILE=$1
    run $PROFILE
    site $PROFILE
    run_like_heroku $PROFILE
}

function qa_before_release(){
    for PROFILE in $PROFILES
    do
        qa_before_release_for_one_profile $PROFILE
    done
}

function usage_steps_by_hand(){
    echo "and now do this on terminal:"
    echo ""
    echo "./mvnw clean release:prepare"
    echo ""
    echo "./mvnw release:perform"
    echo ""
    echo "git commit -m 'after release'"
    echo ""
    echo "git push"
}

qa_before_release
usage_steps_by_hand

exit 0
