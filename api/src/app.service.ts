import { Injectable } from '@nestjs/common';
import {Ligne, Ligne_traitee} from './ligne';
import { InjectModel } from '@nestjs/mongoose';
import {Ligne_traiteeDocument, LigneDocument} from './app.schema';
import {Model} from 'mongoose';

@Injectable()
export class AppService {
  constructor(
    @InjectModel(LigneDocument.name)
    private readonly ligneRepository:Model<LigneDocument>,
    @InjectModel(Ligne_traiteeDocument.name)
   private readonly ligne_traiteeRepository:Model<Ligne_traiteeDocument>
  ) {}
  getAll(): Promise<Ligne[]> {
    return  this.ligneRepository.find().exec();
  }

  addLigne(ligne:Ligne_traitee) :Promise<Ligne_traitee>{
    return this.ligne_traiteeRepository.create(ligne);
  }

}
