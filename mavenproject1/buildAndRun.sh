#!/bin/sh
mvn clean package && docker build -t com.mycompany/mavenproject1 .
docker rm -f mavenproject1 || true && docker run -d -p 8080:8080 -p 4848:4848 --name mavenproject1 com.mycompany/mavenproject1 
