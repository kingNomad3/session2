 #include <fstream>
#include "flux_io.h"
#include "Livres.h"
#include "type.h"
#include "cvm23.h"
#include "utils.h"

const std::string FILENAME_LIVRE = "livres.bin";

void NouveauLivre() {
    Livre_s livre = {};
    std::fstream fichierLivre;
    fichierLivre.open(FILENAME_LIVRE, std::ios::app | std::ios::binary);

        ecrire << "Titre du livre : ";
        LireChaineC(livre.Titre, MAX_CHAR);
        ecrire << "Auteur du livre : ";
        LireChaineC(livre.Auteur, MAX_CHAR);

        livre.Loue = false;

        fichierLivre.write((char*)&livre, sizeof(Livre_s));
        fichierLivre.close();
}


Livre_s RechercherLivre(int id) {
    Livre_s livre = {};
    std::ifstream fichierLivre;
    fichierLivre.open(FILENAME_LIVRE, std::ios::in | std::ios::binary);

    fichierLivre.seekg(sizeof(Livre_s) * id, std::ios::beg);
    fichierLivre.read((char*)&livre, sizeof(Livre_s));
    fichierLivre.close();

    return livre;
}

void AfficherLivre(int id) {
    Livre_s livre = RechercherLivre(id);

    if (strlen(livre.Titre) == 0) { // strlen permet de calculer la longueur d'une chaine de caractere 
        ecrire << "Ce livre n'existe pas";
    }
    else {
        ecrire << "ID du livre : " << id << std::endl;
        ecrire << "Titre du livre : " << livre.Titre << std::endl;
        ecrire << "Auteur du livre : " << livre.Auteur << std::endl;
        ecrire << "Disponible : " << (livre.Loue ? "Non" : "Oui") << std::endl;
    }
}


void MiseAJourLivre(int id, Livre_s livre) {
    std::fstream fichierLivre;

    fichierLivre.open(FILENAME_LIVRE, std::ios::in | std::ios::out | std::ios::binary);
    fichierLivre.seekg(sizeof(Livre_s) * id, std::ios::beg);
    fichierLivre.write((char*)&livre, sizeof(Livre_s));

    fichierLivre.close();
}

void ListeDesLivresPretes() {
    Livre_s livre = {};
    std::fstream fichierLivre;
    
    fichierLivre.open(FILENAME_LIVRE, std::ios::in | std::ios::binary);
  
    ecrire << "Liste des livres Prêtés" << std::endl;
    ecrire << "=======================" << std::endl;
    ecrire << "ID : Titre" << std::endl;
    ecrire << "----------" << std::endl;

    fichierLivre.seekp(0, std::ios::beg);

    while (!fichierLivre.eof()) {
        fichierLivre.read((char*)&livre, sizeof(Livre_s));
        if (!fichierLivre.good()) {
            break;
        }
            if (livre.Loue == true) {

                std::streampos position = fichierLivre.tellp();
                ecrire << (position / sizeof(Livre_s)) - 1 << " : " << livre.Titre;
            }
    }

    fichierLivre.close();
}




