import {Arret} from './arret';

export interface Ligne_traitee{
  favorie:boolean;
  nom: string;
  numero:string;
  type:string;
  color:string;
  arrets:{
    aller: Array<Arret>,
    retour: Array<Arret>};
}

export interface Ligne{
  arrets: Array<number>;
  _id: string;
  datasetid: string;
  recordid: string;
  fields: { object };
  geometry: {object};
  record_timestamp: string;

}
/**
{
  favorie:true;
  nom: 'test';
  numero: 'c1';
  type:'bus';
  color:'ffffff';
  arrets:[{
      ligne:'test',
    type:'bus',
    coordonne:[[43,15]]}]
}**/