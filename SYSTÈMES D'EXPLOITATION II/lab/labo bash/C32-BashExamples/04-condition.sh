#!/bin/bash

# pas d'espace dans les affectation
note=75

# if test ...
# if [...]
# if [[ note -lt 60 ]];then

if [[ note -lt 60 ]]   
then 
    echo "Desolee.. vous echouez"
elif test $note -eq 60
then
echo "ouf"
else
echo "Beau travail!"
fi


read -p "Entrez une lettre" lettre

# ;; est break
# *) est case
# esac est exit
case $lettre in 
    [[:lower:]])
    echo "la lettre est minuscule"
    ;;
    *)
    echo "autre"
    ;;
esac


# losqu on utilise des chaine de caractere on utilise la nomenclature de c++
if[[ $lettre != "a"]]
then
    echo "diff de a"
fi








