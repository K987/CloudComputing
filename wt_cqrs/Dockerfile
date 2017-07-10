FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD ./wt_cqrs/build/libs/wt_cqrs.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENV SPRING_PROFILES_ACTIVE=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
