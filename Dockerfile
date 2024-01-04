FROM adoptopenjdk:17-jdk-hotspot

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn

COPY pom.xml .
COPY src src

RUN ./mvnw clean install -DskipTests

EXPOSE 3000

CMD ["java", "-jar", "target/vuttr-0.0.1-SNAPSHOT.jar"]