import { Controller,Param,Body, Get,Put,Post } from '@nestjs/common';
import { AppService } from './app.service';
import { Ligne } from './ligne';

@Controller('ligne_tan')
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  getAll(): Promise<Ligne[]> {
    return this.appService.getAll();
  }

  @Post()
  addLigne(@Body() newLigne:Ligne):Promise<Ligne> | undefined {
    return this.appService.addLigne(newLigne);
  }
}
