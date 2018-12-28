import * as dotenv from 'dotenv';
import express from 'express';
import bodyParser from 'body-parser';
import path from 'path';
import moment from 'moment';

dotenv.config();

const port = 8000;
const app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.set('view engine', 'pug');
app.set('views', './src/views');
app.use(express.static(path.join(__dirname, '../src')));

//setup locally available resources for use in template
app.locals.moment = moment;

//get value passed from commandline option
const argv = require('yargs').argv;
console.log(JSON.parse(argv.exchangejson));

app.get('/', function (req,res,next) {
    var data = JSON.parse(argv.exchangejson)
    res.render('index', {"data" : data});
})

app.listen(port, () => {
  console.log(`Express server app listening on port ${port}!`);
});

process.on('SIGINT', function() {
    console.log("Exiting app")
    process.exit();
});
