import { Controller,Param,Body, Get,Put,Post } from '@nestjs/common';
import { AppService } from './app.service';
import {Ligne, Ligne_traitee} from './ligne';

@Controller('ligne_tan')
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  getAll(): Promise<Ligne[]> {
    return this.appService.getAll();
  }

  @Post()
  addLigne(@Body() newLigne:Ligne_traitee):Promise<Ligne_traitee> | undefined {
    return this.appService.addLigne(newLigne);
  }
}
