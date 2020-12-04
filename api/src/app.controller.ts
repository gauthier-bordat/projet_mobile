import { Controller,Param,Body, Get,Put,Post,Query } from '@nestjs/common';
import {Search} from './Search';
import { AppService } from './app.service';
import { Ligne_traitee} from './ligne';

@Controller('ligne_tan')
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  getLigne(@Query("favorie")favorie: string): Promise<Ligne_traitee[]> {
    if(favorie==undefined){
      return Promise.resolve(this.appService.getAll());
    }
    else{
    return this.appService.getFavorie();}
  }
  @Get(':nom')
  getbyname(@Param('nom') param: string): Promise<Ligne_traitee>{
    return Promise.resolve(this.appService.getLignebyname(param));
  }
  @Get(':numero')
  getbynumero(@Param('numero')param : string): Promise<Ligne_traitee>{
    return Promise.resolve(this.appService.getLignebynum(param));
  }
  @Post(':nom')
  ajouterFavorie(@Param('nom')param:string):Promise<Ligne_traitee>{
    return Promise.resolve(this.appService.ajouterFavorie(param));
  }
  @Post('/search')
  getLigneLike(@Body()param: Search): Promise<Ligne_traitee[]>{
    return Promise.resolve(this.appService.getLignelike(param));
  }
  @Put()
  addLigne(@Body() newLigne:Ligne_traitee):Promise<Ligne_traitee> | undefined {
    return this.appService.addLigne(newLigne);
  }
}
