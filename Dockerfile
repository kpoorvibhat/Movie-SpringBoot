FROM openjdk:11
ADD ./target/MovieService-0.0.1-SNAPSHOT.jar /usr/src/MovieService-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "MovieService-0.0.1-SNAPSHOT.jar"]
