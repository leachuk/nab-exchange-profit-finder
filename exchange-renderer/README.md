# A minimal web application structure with technologies like node.js, typescript, express

This project is created to help people who wants to start creating application with the TypeScript, Node.js and Express.

## How to run this project:

To run this project first you need to run following command

```sh
    npm install          <= install all the npm Dependencies
    npm start            <= It will run project on port 8000.
```
Or using `ts-node` to run directly
```$xslt
  ts-node src/app.ts --exchangejson='{"foo": "bar"}'
``` 

## Usage
Once running, open a browser with
```$xslt
http://localhost:8000
```

## Docker Usage
Build docker image with 
```bash
docker build -t nab-exchange-renderer .
```

To create a running container with sample `exchangejson` data
```bash
docker run -i -p 8000:8000 -d --name nab-renderer nab-exchange-renderer --exchangejson='[{"currency":"BTC","buyDatetime":{"date":{"year":2018,"month":7,"day":5},"time":{"hour":9,"minute":15,"second":0,"nano":0}},"buyPrice":34.98,"sellDatetime":{"date":{"year":2018,"month":7,"day":5},"time":{"hour":12,"minute":30,"second":0,"nano":0}},"sellPrice":37.01,"profit":2.030000000000001},{"currency":"ETC","buyDatetime":{"date":{"year":2018,"month":7,"day":5},"time":{"hour":9,"minute":15,"second":0,"nano":0}},"buyPrice":34.98,"sellDatetime":{"date":{"year":2018,"month":7,"day":5},"time":{"hour":12,"minute":30,"second":0,"nano":0}},"sellPrice":37.01,"profit":2.030000000000001}]'
```
Then open [http://localhost:8000](http://localhost:8000) in a browser.

## License

MIT
