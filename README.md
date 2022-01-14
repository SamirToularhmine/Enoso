
![](img/logo_small.png)

# Analyseur syntaxique du langage While

## Auteurs :
- Pierre-Louis BERTRAND
- Ionas NEONAKIS
- Thomas QUETIER
- Samir TOULARHMINE

---

Ce projet est un moteur d'analyse syntaxique développé en Java.

# Instructions d'utilisation

Il est possible d'utiliser le moteur d'analyse avec ou sans interface graphique.

**Note :** des programmes d'exemples sont disponibles dans le dossier ```src/main/resources```

### Sans interface graphique
Pour lancer le projet, il suffit d'éxecuter le fichier JAR fourni avec par exemple la commande : 

``` java -jar Enoso.jar ARGUMENTS ```

Voici la liste des arguments disponibles actuellement :

|        Nom de l'argument        | Description de l'argument                                                      |
|:-------------------------------:|:-------------------------------------------------------------------------------|
|          showAnalyses           | Permet de visualiser dans la sortie standard la liste des analyses disponibles |
| getDotName \<cheminProgramme\>  | Permet d'obtenir un chemin vers le graphe du programme (au format dot)         |
| \<cheminProgramme\> \<Analyse\> | Permet de visualiser dans la sortie standard l'analyse appliquée au programme  |

**Note :** il est nécessaire d'exécuter une analyse sur le programme avant de pouvoir obtenir le fichier dot
correspondant à son flow.

Voici la liste des analyses disponibles actuellement :

| Numéro de l'analyse | Nom de l'analyse      |
|:-------------------:|:----------------------|
|          0          | Very Busy Expressions |
|          1          | Reaching Definition   |
|          2          | Available Expressions |
|          3          | Live Variables        |

Exemples d'utilisation :

Voir les différentes analyses disponibles :
```java -jar Enoso.jar showAnalyses```

Obtenir un chemin vers le fichier du flow du programme sous forme de graphe (au format dot) :
```java -jar Enoso.jar getDotName programme.yl```

Effectuer une analyse Very Busy Expressions sur un programme :
```java -jar Enoso.jar programme.yl 0```

Effectuer une analyse Reaching Definition sur un programme :
```java -jar Enoso.jar programme.yl 1```

Effectuer une analyse Available Expressions sur un programme :
```java -jar Enoso.jar programme.yl 2```

Effectuer une analyse Live Variables sur un programme :
```java -jar Enoso.jar programme.yl 3```


### Avec interface graphique

Afin d'utiliser ce moteur avec l'interface graphique, il est nécessaire d'avoir :

- Python installé et utilisable avec la commande python3.
- le paquet Tkinter (livré avec les versions récentes de Python) 
- le paquet Pillow (pip3 install Pillow) 
- le paquet graphviz (commande ```$ dot -Tpng``` nécessaire)

Pour démarrer l'interface graphique, il suffit d'exécuter la commande :
```$ python3 gui.py```

**Note :** Des captures d'écran de l'interface graphique sont disponibles dans le dossier ```img```

## Difficultés rencontrées
