FROM openjdk:11
WORKDIR /usr/app
COPY ./build/libs/MockTransaction-0.0.1-SNAPSHOT.jar /usr/app
RUN sh -c 'cp MockTransaction-0.0.1-SNAPSHOT.jar /usr/app/app.jar'
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]