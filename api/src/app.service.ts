import { Injectable } from '@nestjs/common';
import { Ligne } from './ligne';
import { InjectModel } from '@nestjs/mongoose';
import { LigneDocument } from './app.schema';
import {Model} from 'mongoose';

@Injectable()
export class AppService {
  constructor(
    @InjectModel(LigneDocument.name)
    private readonly ligneRepository:Model<LigneDocument>
  ) {}
  getAll(): Promise<Ligne[]> {
    return this.epurer(this.ligneRepository.find().exec());
  }

  epurer(data:any):Promise<Ligne[]>{
    return this.ligneRepository.find().exec();
}
}
