#!/usr/bin/env bash

export nexusUsername="$1"
export nexusPassword="$2"

./gradlew upload