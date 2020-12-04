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
créer une ligne 
et ajouter une ligne dans ses favoris.
L'application n'est pas encore terminée.

### Avant propos
 Nous avons dans un premier temps du traité les données car le fichier JSON avec le quelle nous avons travaillé comportait beaucoup de données inutiles, et sa structure était inutilement complexe. 


### Part 1: 🍃 API MongoDB

L'APi MongoDB est utilisé ici comme interface pour récupérer et modifié les données d'une base de donnée contenant l'ensemble des lignes. Il se compose principalement d'un `app.controler` et d'un `app.service` contenant respectivement les méthodes pour demander un service et pour traduire la demande à la base MangooDB.
Enfin `app.module`et `app.shema` sont là pour se connecter à la base et pour mettre en forme les données. Le lien de la base de donné utilisé est : mongodb+srv://Bourel_Maisse_Bordat:azerty123@projetbourelbordat.trvaw.mongodb.net/ligne_tan?retryWrites=true&w=majority').build()
Nous avons implémenté plusieurs fonctionnalités : 

- un get qui récupère toutes les données 

- un get/:nom qui récupère les données de la ligne avec le nom voulut

- un get/:numero qui récupère les données de la ligne avec le numéro de ligne voulut

- un post/nom permet de mettre a jour le base de données en signifiant que la ligne avec le nom voulut passe en favori

- un post/search qui permette d'obtenir le résultat d'un recherche

- un put qui permet d'ajouter un élément à la base de données

les données étant très grandes les teste unitaire ne seront pas vérifiés, mais dans l'IDE on peut voire la conformité des réponses ou alors on peut voire les effets escomptés directement sur la base de données. 

### Part 2: Android

Nous avons créé une application android comme IHM en Kotlin, l'idée étant de créer un environnement simplifié d'affichage des lignes et de leurs données. C'est notamment le rôle de `LigneAdapter` et `LigneListFragement`.



 La difficulté étant de réussir à se récupérer les donné de l'API MongoDB. Deux problèmes sont identifiés :
 - la méthode creat de retrofit est impossible à récupérer malgrès les imports des library retrofit2
 - Enfin retrofit est une library de base https, alors que MongoDb est sur serveur Local
 Suit à nos recherche, il semble possible de connecté via retrofit, une base MongoDb mais nos essais se sont soldé par des échecs.
 En revanche, nous n'avons pas de piste pour retrouver la méthode create
 
 
cette application a donc plusieurs fonctionnalités, par soucie technique les données utiliser dns l'application ne sont qu'une petite représentation.
l'application s'ouvre sur un recyclerView d'informations de base des lignes, le type de transport bus/tram est représenté par un icon, le nom et le numéro par du texte, la couleur pas une pastille de couleur et si la ligne est marquée comme favorite l'étoile a sa droite est remplie.

- S'il on clique sur le bouton recherche on peut rechercher dans toutes les lignes, les lignes qui comportent cette séquence de caractères dans leur nom ou numéro, le résultat s'affiche dans un format similaire au MainActivity .

- S'il on clique sur le bouton add on peut rentrer les informations d'une nouvelle ligne (informations succinctes pour que l'application reste lisible) celle-ci vient de suite s'ajouter a la liste.

- S'il on clique sur une ligne on en voit le détaille des arrêts on peut l'ajouter aussi aux favoris avec un bouton ce qui sera visible un foix que l'on revient a l'écran d'affichage


###📝 Library
- Converter: Gson: 'com.squareup.retrofit2:converter-gson:2.6.2'
- Retrofit: 'com.squareup.retrofit2:retrofit:2.6.2'
- Picasso: 'com.squareup.picasso:picasso:2.71828