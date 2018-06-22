#!/usr/bin/env bash

source run-config.sh

build
site integration
run integration

exit 0
