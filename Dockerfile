From openjdk:8
copy ./target/PersonRegistration-0.0.1-SNAPSHOT.jar PersonRegistration-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","PersonRegistration-0.0.1-SNAPSHOT.jar"]