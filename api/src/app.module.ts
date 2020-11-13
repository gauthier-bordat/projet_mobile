import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import {MongooseModule} from '@nestjs/mongoose';
import {LigneDocument, LigneSchema,ArretDocument,ArretSchema} from './app.schema';

@Module({
  imports: [MongooseModule.forRoot('mongodb+srv://Bourel_Maisse_Bordat:pZc2Ab6GL5pTNkLw@projetbourelbordat.trvaw.mongodb.net/ligne_tan?retryWrites=true&w=majority'),
    MongooseModule.forFeature([
        {name: LigneDocument.name,schema: LigneSchema},
        {name: ArretDocument.name,schema: ArretSchema}],
  )],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
/**pZc2Ab6GL5pTNkLw**/