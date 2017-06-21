FROM hypriot/rpi-java

ADD kdo-noel.jar /data/app.jar

EXPOSE 8080

CMD "java" ${JAVA_OPTS} "-Djava.security.egd=file:/dev/./urandom" "-jar" "/data/app.jar"
