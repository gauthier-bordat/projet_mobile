import { Injectable } from '@nestjs/common';
import { Ligne_traitee} from './ligne';
import { Search} from './Search';
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
  getFavorie(): Promise<Ligne_traitee[]>{
    return this.ligne_traiteeRepository.find({favorie:true}).exec();
  }
  getLignelike(param: Search): Promise<Ligne_traitee[]>{
    const regex = new RegExp(param.term);
    return this.ligne_traiteeRepository.find({nom: regex}).exec();
  }
  addLigne(ligne:Ligne_traitee) :Promise<Ligne_traitee>{
    return this.ligne_traiteeRepository.create(ligne);
  }
  getLignebyname(name : string): Promise<Ligne_traitee>{
    return this.ligne_traiteeRepository.findOne({nom: name}).exec();
  }
  getLignebynum(numero : string): Promise<Ligne_traitee>{
    return this.ligne_traiteeRepository.findOne({numero : numero}).exec();
  }
  ajouterFavorie(name :string): Promise<Ligne_traitee>{
    return this.ligne_traiteeRepository.updateOne({nom:name},{$set:{favorie:true}}).exec();
  }


}
