FROM node:11.6-alpine

WORKDIR /app/nab

ADD package*.json /app/nab/
ADD tsconfig.json tslint.json /app/nab/

RUN npm install

# Add app code
ADD src /app/nab/src/

EXPOSE 8000

CMD npm run start -- --exchangejson='[{"currency":"BTC","buyDatetime":{"date":{"year":2018,"month":7,"day":5},"time":{"hour":9,"minute":15,"second":0,"nano":0}},"buyPrice":34.98,"sellDatetime":{"date":{"year":2018,"month":7,"day":5},"time":{"hour":12,"minute":30,"second":0,"nano":0}},"sellPrice":37.01,"profit":2.030000000000001},{"currency":"ETC","buyDatetime":{"date":{"year":2018,"month":7,"day":5},"time":{"hour":9,"minute":15,"second":0,"nano":0}},"buyPrice":34.98,"sellDatetime":{"date":{"year":2018,"month":7,"day":5},"time":{"hour":12,"minute":30,"second":0,"nano":0}},"sellPrice":37.01,"profit":2.030000000000001}]'

