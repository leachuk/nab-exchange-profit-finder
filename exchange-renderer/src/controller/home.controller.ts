import { NextFunction, Request, Response } from 'express'


export default class HomeController {

  public static getDefault(req: Request, res: Response, next: NextFunction) {
    var data = { title: 'Hey', message: 'Hello there!', listinfo: ["foo", "bar", "zoo"] };
    res.render('index', data);
  }
}
