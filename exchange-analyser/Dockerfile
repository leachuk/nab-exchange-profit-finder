FROM openjdk:12-jdk-alpine

RUN mkdir -p /app/nab

//todo: convert to use jar with dependencies
COPY target/production/nab-exchange-profit-finder /app/nab/

ENTRYPOINT ["java", "-cp", "/app/nab", "com.exchangeanalyser.ExchangeAnalyser"]