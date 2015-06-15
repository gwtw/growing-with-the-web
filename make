#!/bin/bash

mkdir -p bin
# Surely there's a better way to do this
javac -d ./bin -cp "lib/junit-4.11.jar" \
	./src/com/growingwiththeweb/*/*.java \
	./src/com/growingwiththeweb/*/*/*.java \
	./test/com/growingwiththeweb/*/*.java \
	./test/com/growingwiththeweb/*/*/*.java
