import { Test, TestingModule } from '@nestjs/testing';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { AppModule } from './app.module';
import { INestApplication } from '@nestjs/common';
import supertest from 'supertest';
import * as request from 'supertest';

describe('AppController', () => {
  let app: INestApplication;
  let httpRequester: supertest.SuperTest<supertest.Test>;
  beforeEach(async () => {
    const moduleRef = await Test.createTestingModule({
      imports:[AppModule],
    }).compile();
    if(moduleRef){    app = moduleRef.createNestApplication();}

    await app.init();

    httpRequester = request(app.getHttpServer())

  });


    it('/GET devrais tout retourner', async () => {
      const response =  await httpRequester.get('/lignes_tan').expect(200);
      expect(response.body).toBe(
        ''
      );
    });
  });
