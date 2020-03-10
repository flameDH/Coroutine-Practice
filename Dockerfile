FROM zenika/kotlin
MAINTAINER Alston
ADD . /starter
WORKDIR /starter


#produce deploy ver
RUN sh mvnw package
ENTRYPOINT java -jar target/starter-1.0.0-SNAPSHOT.jar
