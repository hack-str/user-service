FROM nimmis/java-centos:openjdk-8-jdk

ARG JDBC_SCHEMA
ENV DB_SCHEMA=${DB_SCHEMA}

ARG DB_URL
ENV DB_URL=${DB_URL}

ARG DB_USER
ENV DB_USER=${DB_USER}

ARG DB_PASS
ENV DB_PASS=${DB_PASS}

COPY ./target/user-service.jar /usr/local/src/
WORKDIR /usr/local/src/
CMD ["java", "-jar", "./user-service.jar"]
