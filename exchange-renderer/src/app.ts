import * as dotenv from 'dotenv';
import express from 'express';
import bodyParser from 'body-parser';
import path from 'path';

dotenv.config();

const port = 8000;
const app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.set('view engine', 'pug');
app.set('views', './src/views');
app.use(express.static(path.join(__dirname, '../src')));

//get value passed from commandline option
const argv = require('yargs').argv;
console.log(JSON.parse(argv.exchangejson));

app.get('/', function (req,res,next) {
    //var data = { title: 'Hey', message: 'Hello there!', listinfo: ["foo1", "bar1", "zoo1"] };
    res.render('index', JSON.parse(argv.exchangejson));
})

app.listen(port, () => {
  console.log(`Express server app listening on port ${port}!`);
});
