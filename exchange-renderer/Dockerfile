FROM node:11.6-alpine

# Becuase you can't use ARG in ENTRYPOINT, so need to define as ENV
ENV EXCHANGEJSON {}

WORKDIR /app/nab

ADD package*.json /app/nab/
ADD tsconfig.json tslint.json /app/nab/
COPY run.sh /app/nab/

RUN npm install
RUN chmod +x /app/nab/run.sh

# Add app code
ADD src /app/nab/src/

EXPOSE 8000

ENTRYPOINT /app/nab/run.sh --exchangejson=$EXCHANGEJSON