FROM openjdk:21

WORKDIR /app

COPY custom-jre /app/jre

COPY build/libs/SpringBootRESTAPI-0.0.1-SNAPSHOT.jar app.jar

ENV JAVA_HOME=/app/jre

ENV PATH="$JAVA_HOME/bin:$PATH"

EXPOSE 9090

ENTRYPOINT [ "java", "-jar", "app.jar" ]