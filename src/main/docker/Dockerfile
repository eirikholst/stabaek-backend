FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD stabaek-backend-0.0.1-SNAPSHOT.jar stabaek-backend.jar
RUN sh -c 'touch /stabaek-backend.jar'
ENV JAVA_OPTS=""
EXPOSE 8888
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /stabaek-backend.jar" ]