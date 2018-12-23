#Exchange Analyser
A java class which takes a list of exchange trades in the form of:
```
<currency_type> <trade_timestamp> <trade_value>
```
It performs a basic analysis using the [Stock Span Alogorithm](https://www.geeksforgeeks.org/the-stock-span-problem/) 
and outputs the most profitable trade series in the following JSON array format

```json
[
  {
    "currency": "BTC",
    "buyDatetime": {
      "date": {"year": 2018,"month": 7,"day": 5},
      "time": {"hour": 9,"minute": 15,"second": 0,"nano": 0}
    },
    "buyPrice": 34.98,
    "sellDatetime": {
      "date": {"year": 2018,"month": 7,"day": 5},
      "time": {"hour": 12,"minute": 30,"second": 0,"nano": 0}
    },
    "sellPrice": 37.01,
    "profit": 2.030000000000001
  },
  {...}
]
```

## To build
Using the Spotify `dockerfile-maven-plugin` to integrate the java build with the docker build, simply run:
```bash
mvn clean package
```

Once complete, you will have docker image `nab-exchange-analyser:<version>` available to run:
```bash
$ docker ps --all
CONTAINER ID        IMAGE                                  COMMAND                  CREATED             STATUS                     PORTS               NAMES
f32cb9e6dde2        nab-exchange-analyser:0.0.1-SNAPSHOT   "/bin/sh -c 'java -j…"   4 seconds ago       Exited (0) 3 seconds ago                       nab-test
```

## To run
```bash
docker run --name nab-test nab-exchange-analyser:0.0.1-SNAPSHOT
```

