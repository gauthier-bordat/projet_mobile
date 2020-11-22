import {Arret} from './arret';


export interface Ligne_traitee{
  _id: string;
  favorie:boolean;
  nom: string;
  numero:string;
  type:string;
  color:string;
  arrets:{
    aller: Array<Arret>,
    retour: Array<Arret>};
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