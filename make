#!/bin/bash

mkdir -p bin
javac -d ./bin -cp "lib/junit-4.11.jar" ./com/growingwiththeweb/*/*.java
