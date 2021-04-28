FROM adoptopenjdk/openjdk11-openj9
RUN mkdir /artifact
COPY ./target/camelk8shutdownhook-0.0.1-SNAPSHOT.jar /artifact/sbapp.jar
EXPOSE 8080
#RUN ls -lrt /artifact
ENTRYPOINT [ "java","-jar","/artifact/sbapp.jar" ]