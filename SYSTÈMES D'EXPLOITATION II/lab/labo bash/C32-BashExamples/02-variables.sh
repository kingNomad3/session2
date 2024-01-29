#!/bin/bash

#pour affecter une variable il ne faut pas mettre d'espace

prenom=Benjamin

echo $prenom
# declare rarement utiliser
declare -i age=33
# -r donne une constante
declare -r CHEMIN=/bin

# $0 donn e le premier script
echo "Nom script" $0

# $# veut dire combien on passe  de paramettre
echo "Nombre params" $#