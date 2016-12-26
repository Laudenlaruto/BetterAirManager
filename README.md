# BetterAirManagerProjet Java
Notes en préambule :
— le travail doit se faire en binome ;
— soyez concis et précis, et justifiez vos réponses par des commentaires appropriés ;
— soyez rigoureux dans la syntaxe Java ;
Étude de cas. L’équipage d’un avion est toujours constitué d’un pilote, d’un copilote et de plusieurs
personnels naviguants et commerciaux (PNC). Chacune de ces personnes est identifiée par son nom
et sa fonction. L’équipage d’un avion est reconstitué pour chacun de ses vols.
Chaque membre d’équipage doit être opérationnel sur deux types d’avions (par exemple le PNC
Richard est opérationnel sur Airbus A320, et Boeing 747). Chaque type d’avion a un nombre de PNC
dans son équipage oscillant entre un minimum et un maximum. Pour l’exemple nous choisirons le
nombre de PNC des Airbus A320 entre deux et trois et ceux d’un B747 entre trois et quatre.
L’objectif du système à modéliser est de constituer des tableaux de service. Les membres de
l’équipage peuvent visualiser les vols dans lesquels ils ont été affectés. L’administrateur du système
peut créer et supprimer des entités dans le système. Le manager peut ajouter et supprimer des
personnes dans un équipage pour un vol donné (un vol est désigné par un numéro de vol et une
date), les données du vol sont archivées après le vol pour une année.
La figure 1 est un extrait du tableau de service de quelques employés de la compagnie AIR France.
Pour simplifier, le tableau n’en représente que quelques-uns.

Partie 1 : Conception
1. Reprendre la conception proposée en y utilisant et en justifiant :
o Des packages, Des interfaces
o Des classes abstraites, internes
2. Proposer au moins deux exceptions et utiliser les
Partie 2 : Persistance
1. L’ensemble des aéroports est stockés dans un fichier donnée en sérialisant la classe
correspondante
2. L’ensemble des données des vols, personnels est stocké dans une base
Partie 3 : Interface Graphique
1. Proposer une interface graphique pour afficher le tableau
2. Proposer une interface graphique pour mettre à jour les données de vols par un des acteurs
