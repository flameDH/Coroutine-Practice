#!/bin/bash

sh mvnw install
docker build -t testserver .
