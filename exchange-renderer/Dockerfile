FROM node:11.6-alpine

WORKDIR /app/nab

ADD package*.json /app/nab/
ADD tsconfig.json tslint.json /app/nab/

RUN npm install

# Add app code
ADD src /app/nab/src/

EXPOSE 8000

CMD npm run start

