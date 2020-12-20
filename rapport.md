# Rapport 

## Combien de tableaux ont été extraits?

Une fois le benchmark test lancé, 336 pages sont traités et 1662 tableaux ont été extraits.     

## Combien de colonnes, de lignes, et de cellules sont présentes dans les tableaux extraits? 

Une fois que le test benchmark est fini, l'application wikimatrix a traitées 336 pages internet dont 33 mène à une erreur 404. 

Sur les 336 pages traités, 1662 tableaux ont été extraits. Ces tableaux ont en moyenne 7 colonnes. Le plus grand tableau à 37 colonnes, le plus petit en a 0. 

Sur ces 1662 tableaux, 1068 ont des problèmes : ils n'ont pas le même nombre de colonnes pour toutes leurs lignes. Cela est dû au problème de traitement du rowspan. 
    
    
## Qualité et faiblesse de votre extracteur

Qualité : L'extracteur ne semble pas avoir de problème dans le sens où aucune des 365 page ne fait planter le code.

Faiblesse : La gestion des rowspans - et notamment des rowspan qui ont un colspan - est bancale et ne marchera pas dans la plupart des cas. De plus, certains headers composé uniquement de lien hypertexte ne peuvent être extrait via cette application. 
    
## Synthèse générale: est-ce que les tableaux de Wikipedia que vous avez extrait sont exploitables par des outils statistiques?

Les tableaux basiques composés uniquement de headers peuvent - dans la plupart des cas - être exploitable par la suite via des logiciels d'outils statistique (cela n'est en effet pas le cas pour ceux dont les headers sont composé de lien hypertexte). 
Les tableaux qui comportent des rowspans et des colspan peuvent être ouvert à l'aide de logiciels statistiques, cependant, ils nécessitent un traitement humain avant de pouvoir être exploitable à des fins statistiques. 

De plus, il est à noter qu'il peut subsister des problèmes liés à l'encodage. 

