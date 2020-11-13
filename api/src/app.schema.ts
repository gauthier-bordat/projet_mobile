import {Prop, Schema, SchemaFactory } from '@nestjs/mongoose';
import {Document } from 'mongoose';
import { Arret } from './arret';

@Schema({collection: 'lignes-gme'})
export class LigneDocument extends Document{
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

export const LigneSchema = SchemaFactory.createForClass(LigneDocument);

@Schema({collection: 'arret-gme'})
export class ArretDocument extends Document{
  @Prop()
  ligne: string ;

  @Prop()
  type: string ;

  @Prop()
  coordonnee: Array<number>;
}

export const ArretSchema = SchemaFactory.createForClass(ArretDocument);