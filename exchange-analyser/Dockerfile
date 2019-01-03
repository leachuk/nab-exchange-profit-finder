FROM openjdk:8-jdk-alpine

ARG JAR_FILE
# Becuase you can't use ARG in ENTRYPOINT, so need to define as ENV
ENV jar=$JAR_FILE

RUN mkdir -p /app/nab

ADD target/${JAR_FILE} /app/nab/${JAR_FILE}

RUN echo ${JAR_FILE}

# Both ARG and ENV are not expanded in ENTRYPOINT or CMD, so have to use plaintext version so $jar can be read
ENTRYPOINT java -jar /app/nab/$jar


