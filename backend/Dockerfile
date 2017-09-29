FROM openjdk:latest
VOLUME /tmp
ADD target/backend-*.jar app.jar
ENV JAVA_OPTS=""
CMD ["mvnw", "package"]
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
