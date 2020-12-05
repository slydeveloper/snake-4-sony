#!/bin/bash

TAG=1.0

git tag -a v $TAG -m "Add version $TAG"
git push --tags