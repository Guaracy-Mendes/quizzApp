FROM eclipse-temurin:21-jdk as builder
WORKDIR /quizzapp-backend
COPY . /quizzapp-backend
RUN chmod +x ./mvnw
RUN ./mvnw clean package

FROM eclipse-temurin:21-jre as runner
EXPOSE 8080
COPY --from=builder /quizzapp-backend/target/*.jar /quizzapp-backend.jar

ENTRYPOINT ["java", "-jar", "/quizzapp-backend.jar", "$ARGS"]
