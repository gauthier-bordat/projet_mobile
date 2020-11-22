import { Injectable } from '@nestjs/common';
import { Ligne_traitee} from './ligne';
import { InjectModel } from '@nestjs/mongoose';
import {Ligne_traiteeDocument} from './app.schema';
import {Model} from 'mongoose';

@Injectable()
export class AppService {
  constructor(
    @InjectModel(Ligne_traiteeDocument.name)
   private readonly ligne_traiteeRepository:Model<Ligne_traiteeDocument>
  ) {}
  getAll(): Promise<Ligne_traitee[]> {
    return  this.ligne_traiteeRepository.find().exec();
  }

  addLigne(ligne:Ligne_traitee) :Promise<Ligne_traitee>{
    return this.ligne_traiteeRepository.create(ligne);
  }

}
