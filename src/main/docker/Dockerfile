FROM hypriot/rpi-java

ADD src/main/docker/qemu-arm-static /usr/bin
ADD kdo-noel.jar /data/app.jar

EXPOSE 8080

CMD "java" ${JAVA_OPTS} "-Dspring.profiles.active=prod" "-Djava.security.egd=file:/dev/./urandom" "-jar" "/data/app.jar"
