#!/bin/bash

valeur=$((10+10))
echo $valeur

read -p "nb 1:" nb1
read -p "nb 2:" nb2

# utiliser let peut aussi faire des calcules
let resultat-$nb1*$nb2
echo $resultat

