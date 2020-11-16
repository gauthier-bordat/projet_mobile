import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import {MongooseModule} from '@nestjs/mongoose';
import {Ligne_traiteeDocument, Ligne_traiteeSchema,ArretDocument,ArretSchema,LigneDocument,LigneSchema} from './app.schema';
import {connection} from "mongoose";

@Module({
  imports: [MongooseModule.forRoot('mongodb+srv://Bourel_Maisse_Bordat:azerty123@projetbourelbordat.trvaw.mongodb.net/ligne_tan?retryWrites=true&w=majority'),
      MongooseModule.forFeature([
        {name: ArretDocument.name,schema: ArretSchema},
        {name: LigneDocument.name,schema: LigneSchema}],

  ),
      MongooseModule.forRoot('mongodb+srv://Bourel_Maisse_Bordat:azerty123@projetbourelbordat.trvaw.mongodb.net/ligne_tan?retryWrites=true&w=majority'),
      MongooseModule.forFeature([
              {name: Ligne_traiteeDocument.name,schema: Ligne_traiteeSchema}],)
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
