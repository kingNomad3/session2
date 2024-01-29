#!/bin/bash

# -e fichier exist?
# -f c'est un fichier?
# -d c'est un dossier?

if [[-e $1]]
then
    echo "le fichier exite"
if