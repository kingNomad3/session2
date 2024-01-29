#!/bin/bash

# -a est array a l'indice 1 on The et a l'indice deux on a matrice
declare -a film(The Matrix)
echo $(film[0])
echo $(film[1])
echo "nombre elem:" $(film[@])
# @ est le nombre delement