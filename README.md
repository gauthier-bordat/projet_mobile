[![Mines St Etienne](./logo.png)](https://www.mines-stetienne.fr/)

# Les Lignes de transports (v.0.9)

Par :
- Bordat Gauthier
- Bourel Vincent

##  🚀 Objectifs

L'objectif était de créer une base de donnée répertoriant les différentes lignes de bus, train et autres type de transports en commun, ainsi qu'une application android dédié.
Cette application devait apporter plusieurs outils de manipulation de la base par l'utilisateur.
Il peut ainsi :
récupérer l'ensemble des lignes,
récupérer l'ensemble des données d'une ligne,
et ajouter une ligne dans ses favoris.
L'application n'est pas encore terminée.

### Part 1: 🍃 API MongoDB

L'APi MongoDB est utilisé ici comme interface pour récupérer et modifié les données d'une base de donnée contenant l'ensemble des lignes. Il se compose principalement d'un `app.controler` et d'un `app.service` contenant respectivement les méthodes pour demander un service et pour traduire la demande à la base MangooDB.
Enfin `app.module`et `app.shema` sont là pour se connecter à la base et pour mettre en forme les données. Le lien de la base de donné utilisé est : mongodb+srv://Bourel_Maisse_Bordat:azerty123@projetbourelbordat.trvaw.mongodb.net/ligne_tan?retryWrites=true&w=majority').build()

### Part 2: Android

Nous avons cré une application android comme IHM en Kotlin, l'idée étant de créer un environnement simplifié d'affichage des lignes et de leurs données. C'est notamment le rôle de `LigneAdapter` et `LigneListFragement`.
 La difficulté étant de réussir à se récupérer les donné de l'API MongoDB. Deux problèmes sont identifiés :
 - la méthode creat de retrofit est impossible à récupérer malgrès les imports des library retrofit2
 - Enfin retrofit est une library de base https, alors que MongoDb est sur serveur Local
 Suit à nos recherche, il semble possible de connecté via retrofit, une base MongoDb mais nos essais se sont soldé par des échecs.
 En revanche, nous n'avons pas de piste pour retrouver la méthode create

##📝 Library
- Converter: Gson: 'com.squareup.retrofit2:converter-gson:2.6.2'
- Retrofit: 'com.squareup.retrofit2:retrofit:2.6.2'
- Picasso: 'com.squareup.picasso:picasso:2.71828