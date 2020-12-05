#!/bin/bash

./gradlew desktop:dist
./gradlew android:assembleDebug

ls -la desktop/build/libs
ls -la android/build/outputs/apk