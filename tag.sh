#!/bin/bash

TAG="v1.0"

git tag -a $TAG -m "Add version $TAG"
git push --tags