import { Test, TestingModule } from '@nestjs/testing';
import { AppController } from './app.controller';
import { AppModule } from './app.module';
import { INestApplication } from '@nestjs/common';
import supertest from 'supertest';
import * as request from 'supertest';
import {Ligne_traitee} from "./ligne";
import {Arret} from "./arret";
import * as mongoose from "mongoose";



describe('AppController', () => {
  let app: INestApplication;
  jest.setTimeout(20000);
  let httpRequester: supertest.SuperTest<supertest.Test>;
  beforeEach(async () => {
    const moduleRef = await Test.createTestingModule({
      imports:[AppModule],
    }).compile();
    app = moduleRef.createNestApplication();

    await app.init();

    httpRequester = request(app.getHttpServer());

  });


    it('/GET devrais tout retourner', async () => {

      const response =  await httpRequester.get('/ligne_tan').expect(200);

      expect(response.body).toMatchObject(
          {
            favorie:true,
            nom: 'test',
            numero: 'c1',
            type:'bus',
            color:'ffffff',
            arrets:[{
              ligne:'test',
              type:'bus',
              coordonne:[[43,15]]}]
          }
      );
    });
  });



/**
function traiter(obj:any) :Array<Ligne_traitee>{
    const rep : Array<Ligne_traitee> = [];
    for(let i = 0;i<obj.length;i++){
        if(obj[i].fields == undefined){break;}
        const arretsRetour : Array<Arret> = [];
        const arretsAller : Array<Arret> = [];
        for(let j = 0;j<obj[i].fields.shape.coordinates[0].length;j++){
            const arret :Arret = {
                ligne: obj[i].fields.route_long_name,
                type: obj[i].fields.route_type,
                coordonnee: [obj[i].fields.shape.coordinates[0][j][0],
                    obj[i].fields.shape.coordinates[0][j][1]]
            };
            arretsAller.push(arret);
        }
        if(obj[i].fields.shape.coordinates.length == 2){
        for(let j = 0;j<obj[i].fields.shape.coordinates[1].length;j++){
            const arret :Arret = {
                ligne: obj[i].fields.route_long_name,
                type: obj[i].fields.route_type,
                coordonnee: [obj[i].fields.shape.coordinates[1][j][0],
                    obj[i].fields.shape.coordinates[1][j][1]]
            };
            arretsRetour.push(arret);
        }}
        const ligne : Ligne_traitee = {
            _id:obj[i]._id.toString(),
            favorie:false,
            nom: obj[i].fields.route_long_name,
            numero:obj[i].fields.route_short_name,
            type:obj[i].fields.route_type,
            color:obj[i].fields.route_color,
            arrets:{
                aller: arretsAller,
                retour: arretsRetour}};
        rep.push(ligne);
    }
    return rep;
}**/