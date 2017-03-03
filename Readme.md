# TP Architecture Logicielle / Inf4043 - 2017 - Jeux de lettres
### ROJO Sylvain ROJO Martin


### Pour lancer le projet ###

> Lancement du projet
> Lancement du projet


### Utilisation de singleton

> Nous avons utilis� un singleton pour notre classe potCommun
> C'est une classe qui ne devra �tre instanci�e qu'une seule fois
> Le singleton nous permet de bien ma�triser l'unique instance du potCommun


- Date de rendu : 12/02/2017 23h - pas de retard accepté
- Binôme accepté
- Contacts : 
  - mlab.cours[at]gmail[dot]com (TP à rendre à cette adresse)
  - ledoyen.esiea[at]gmail[dot]com

## Règles du jeux 

- Objectif du jeux :
  - Le premier joueur ayant 10 mots gagne la partie

- Déroulement du jeux :
  - Chacun des joueurs tire une lettre aléatoire d'un sac, et les mettent au milieu dans le pot commun
  - Le joueur qui a tiré la lettre la plus petite lettre dans l'alphabet commence
  - Chaque fois que c'est le début du tour d'un joueur il tire deux lettres aléatoires qu'il rajoute au pot commun
  - Chaque fois qu'un joueur fait un mot il tire une lettre aléatoire qu'il rajoute au pot commun
  - Quand le joueur ne trouve plus de mot il passe et le joueur suivant commence son tour (par tirer 2 lettres qu'il rajoute au pot commun)

- Comment faire un mot ?
  - En utilisant uniquement les lettres du pot commun
  - En prenant un mot de ces adversaires (toutes les lettres du mot) et en lui rajoutant des lettres du pot commun
  - En rallongeant un de ces mots avec des lettres du pot commun ou en utilisant un autre mot (toutes les lettres)
  - Attention, seul les noms communs sont autorisés

- Pour faciliter :
  - les lettres possibles sont uniquement les 26 de l'alphabet (ex : é <-> e)
  - les mots composés sont considérés comme deux mots

- Pour les plus avancés :
  - Le cas des anagrammes :
    - On peut voler un mot en faisant un anagramme uniquement si il n'a pas déjà été fait. Bien entendu, faire un anagramme permet de tirer une nouvelle lettre.

## Objectif du TP

- Une première étape consiste à pouvoir jouer à plusieurs autour d'un même écran.
- Une interface en ligne de commande est suffisante.
- Nous attendons aussi a minima une de ces deux extensions (ou les deux pour les plus courageux :-)) :
  - Une architecture client / serveur, chaque joueur utilisant une instance d'un client pour jouer.
  - Une intelligence artificiel permettant de jouer contre l'ordinateur.
- Nous attendons aussi une description de votre architecture (Quel responsabilité à chaque package, ..).
- De plus, vous devrez illustrer trois principes SOLID ou design pattern en utilisant vos propres classes. 
  - pourquoi avez-vous utilisé ce design pattern / principe ? Qu'est-ce que cela vous a apporté ? Comment l'avez-vous appliqué ?
  - Nous attendons quelques paragraphes seulement
- Ces deux exercices sont à livrer dans le README.md du projet.

## Technologies à utiliser 

- Le TP devra être rendu sur github et donc être gérer via Git
  - Plusieurs commits par personne sont attendus! 
- Le projet doit être rendu en Java. 
- Le projet devra pouvoir être compiler et lancer en ligne de commande (sans IDE) :
  - L'utilisation de `Maven` ou `Gradle` est recommandée 
  - cela ne sert a rien de commiter une jar. Nous n'exécuterons que du code compilé par nous même.
- Le projet doit contenir des tests unitaires
  - Utilisation de `JUnit` ou `Test-ng`
  - L'utilisation des librairies comme `assertJ` et `Mockito` est recommandé.

## Comment rendre son TP

- Merci d'envoyer **un mail dont le sujet est `nom_binome1 | nom_binome2 | url_github`**
  - Tout non respect de cette règle entrainera un 0 au TP (Un script récupérera les projets)
- Tout les exercices demandés (autre que le code) sont à livrer au [format markdown](https://guides.github.com/features/mastering-markdown/) dans un README.md à la racine de votre projet.
  - Le README.md peut référencer d'autres fichiers markdown situés dans le projet 

- Une grande importance sera attachée à la qualité du code, à la conception objet et au découpage par fonctionnalités avec des contrats clairs. 
- Nous vous encourageons à utiliser des analyseurs de code statiques (PMD, findbugs, ...). Nous les utiliserons pour corriger.
- Nous encourageons aussi une approche TDD sur le projet. 

## Points d'attention lors de la correction

- Respect des consignes de rendu de projets
- Des explications claires et fonctionnelles pour compiler et lancer le projet situé dans le README.md. 
- Barèmes :

| Points | Description           | 
| :----- |:-------------| 
|5 points | Architecture du code, découpage des classes, respect des principes Objects (SOLIDE), méthodes < 15 lignes... |
|5 points | La totalité des feature faites. Pas de bug et cas aux limites gérés  |
|3 points | Test : code coverage > 70%, assertions intelligentes dans les tests , tests unitaires |
|2 point  | Exercice Architecture & Design Pattern / Solid |
|2 points | Analyse statique de code findbug / PMD |
|2 point  | Utilisation de Maven (ou autre logiciel du même type) pour gérer les dépendances et construire le projet. Utilisation de git avec plusieurs commits pour chaque personnes du binome |
|1 point  | Conventions java / Maven respectées (Camelcase, package, ...) |

## Bootstrap du projet

Pour faciliter le début nous vous proposons :

```
$ git clone https://github.com/MLabusquiere/TP_4A_2017_Letter_Game.git LetterGame
$ cd LetterGame
$ git remote rm origin
$ git remote add origin <your_git_repository_url>
$ git push -u origin master
```
