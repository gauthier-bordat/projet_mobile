import {Prop, Schema, SchemaFactory } from '@nestjs/mongoose';
import {Document } from 'mongoose';
import { Arret } from './arret';

@Schema({collection: 'ligne_traitee_tan'})
export class Ligne_traiteeDocument extends Document{
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
  arrets:Array<Arret>;
}

export const Ligne_traiteeSchema = SchemaFactory.createForClass(Ligne_traiteeDocument);

@Schema({collection: 'lignes_tan'})
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

@Schema({collection: 'arret_tan'})
export class ArretDocument extends Document{
  @Prop()
  ligne: string ;

  @Prop()
  type: string ;

  @Prop()
  coordonnee: Array<number>;
}

export const ArretSchema = SchemaFactory.createForClass(ArretDocument);