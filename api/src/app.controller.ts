import { Controller,Param,Body, Get,Put } from '@nestjs/common';
import { AppService } from './app.service';
import { Ligne } from './ligne';

@Controller('/lignes_tan')
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  getAll(): Promise<Ligne[]> {
    return this.appService.getAll();
  }
}
