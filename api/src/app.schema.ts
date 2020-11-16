import {Prop, Schema, SchemaFactory } from '@nestjs/mongoose';
import {Document } from 'mongoose';
import { Arret } from './arret';
import * as mongoose from "mongoose";

@Schema({collection: 'ligne_traitee_tan'})
export class Ligne_traiteeDocument extends Document{
  @Prop()
  _id:mongoose.Types.ObjectId;

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

@Schema({collection: 'ligne_tan_traitee'})
export class LigneDocument extends Document{
  @Prop()
  arrets: Array<number>;

  @Prop()
  _id: string;

  @Prop()
  datasetid: string;

  @Prop()
  recordid: string;

  @Prop()
  fields: { object };

  @Prop()
  geometry: {object};

  @Prop()
  record_timestamp: string;
}

export const LigneSchema = SchemaFactory.createForClass(LigneDocument);

