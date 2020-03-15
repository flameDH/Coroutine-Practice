FROM zenika/kotlin
MAINTAINER Alston

COPY ./target/starter-1.0.0-SNAPSHOT-fat.jar   /starter/starter-1.0.0-SNAPSHOT-fat.jar
WORKDIR /starter

ENTRYPOINT java -jar starter-1.0.0-SNAPSHOT-fat.jar
