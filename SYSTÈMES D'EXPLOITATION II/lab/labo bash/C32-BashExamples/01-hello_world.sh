#!/bin/bash

# wasfasdf
echo "Hello World" $USER
# exit

# -n pas de retour a la ligne
echo -n "Vive "
echo "Linux"

# -e permet d'interpreter les retours de la ligne et etc (\n \t
echo -e "1\n2\n3"

# poser question a un usager
read -p "Quel age avez vous" age

# o; fait ,ettre lesing ede dollar avant d'appeler la variable
echo $age "!vous etes jeunes"

