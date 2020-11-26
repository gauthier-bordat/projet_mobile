import {Prop, Schema, SchemaFactory } from '@nestjs/mongoose';
import {Document } from 'mongoose';
import { Arret } from './arret';

@Schema({collection: 'ligne_traitee_tan'})
export class Ligne_traiteeDocument extends Document{
  @Prop()
  _id:string;

  @Prop()
  favorie:boolean;

  @Prop()
  nom: string;

  @Prop()
  numero:string;

  @Prop()
  type:string;

  @Prop()
  color:string;

  @Prop()
  arrets:{ aller:Array<Arret>,
    retour:Array<Arret>};
}

export const Ligne_traiteeSchema = SchemaFactory.createForClass(Ligne_traiteeDocument);



