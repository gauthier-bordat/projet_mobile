import {Arret} from './arret';

export interface Ligne{
  favorie:boolean;
  nom: string;
  numero:string;
  type:string;
  color:string;
  arrets:Array<Arret>;
}