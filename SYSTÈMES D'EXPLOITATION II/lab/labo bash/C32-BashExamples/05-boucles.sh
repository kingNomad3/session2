#!/bin/bash

# pas besoin de signe de dollar
for((i=0;i<5;i++))
do 
echo $i 
done 

# `` = execution de commande et mettre dans variable

liste = `ls`

for fichier in $liste
do
    echo $fichier
done


resultat =o
# les espaces sont important dans la condition 
while[[ $resultat = o ]]
do 
read -p "choix : " resultat