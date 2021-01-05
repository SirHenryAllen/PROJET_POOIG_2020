# PROJET POO 2020

*Production d'un mini jeu se basant sur le principe de **Pet Rescue Saga***


##Architecture##

Le projet contient 5 packages :
 - **control** : les classes permettant de commander les différentes actions par l'utilisateur
 - **Interface** : toutes les interfaces créées pour le fonctionnement du projet
 - **Menu** : package contenant la classe d'entrée du programme (Settings) et celles pour organiser les différentes composantes des menus du jeu
 - **model** : les classes regroupant toutes les fonctions permettant de traiter les données du jeu (ajout d'éléments sur la grille de jeu, chute des éléments, suppression...)  
 - **view** : tous les visuels et vues du projet


## Compiler & executer le projet


### Via la console

1. ``cd PROJET_POOIG_2020/src/Menu``
2. ``javac Settings.java``
3. ``java Settings``

### Via un IDE

1. importer le projet : open folder -> PROJET_POOIG_2020
2. Run le projet : ``F5`` 
3. si l'IDE demande la class "cible" (même si normalement cela est précisé dans le fichier launch.json), sélectionner : ``Menu.Settings`` (contient la fonction main)