FROM gcr.io/distroless/java17:latest

ARG APP_JAR

USER nonroot
WORKDIR /workdir

COPY --chown=nonroot $APP_JAR app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]