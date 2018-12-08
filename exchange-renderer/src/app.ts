import * as dotenv from 'dotenv';
import express from 'express';
import ExpressRouter from './express.router';
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


const expressRoutes = new ExpressRouter(app);
expressRoutes.init();

app.listen(port, () => {
  console.log(`Express server app listening on port ${port}!`);
});
