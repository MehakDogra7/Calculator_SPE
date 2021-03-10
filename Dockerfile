FROM openjdk:8
MAINTAINER Mehak Dogra mehak.dogra@iiitb.org
COPY ./target/calculator-devops-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "calculator-1.0-SNAPSHOT.jar"]