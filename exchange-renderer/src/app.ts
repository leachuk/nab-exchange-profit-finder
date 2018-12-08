import * as dotenv from 'dotenv';
import express from 'express';
import ExpressRouter from './express.router';

dotenv.config();

const port = 8000;
const app = express();
app.set('view engine', 'pug');
app.set('views', './src/views');

const expressRoutes = new ExpressRouter(app);
expressRoutes.init();

app.listen(port, () => {
  console.log(`Express server app listening on port ${port}!`);
});
