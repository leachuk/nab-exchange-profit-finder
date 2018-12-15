FROM openjdk:12-jdk-alpine

RUN mkdir -p /app/nab

COPY target/production/nab-exchange-profit-finder /app/nab/

ENTRYPOINT ["java", "-cp", "/app/nab", "com.exchangeanalyser.ExchangeAnalyser"]