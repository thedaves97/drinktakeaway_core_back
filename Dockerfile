FROM openjdk:14
EXPOSE 1111
ADD target/drinktakeaway_core_back-0.0.1-SNAPSHOT.jar drinktakeaway_core_back-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/drinktakeaway_core_back-0.0.1-SNAPSHOT.jar"]