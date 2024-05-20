#include "type.h"
#include "Livres.h"
#include "Clients.h"
#include "utils.h"
#include <fstream>
#include "flux_io.h" 
#include "cvm23.h"



Date_s Location(int client_id, int livre_id) {
    Livre_s livre = {};
    Pret_s pret = {};
    Client_s client = {};
    Date_s location = Aujourdhui(), retour = AjouterJours(location, 15);
    Date_s dateDeRetour = {};

    std::fstream fichierLivre;
    fichierLivre.open(FILENAME_LIVRE, std::ios::in | std::ios::out | std::ios::binary);
    fichierLivre.seekg(sizeof(Livre_s) * livre_id, std::ios::beg);
    fichierLivre.read((char*)&livre, sizeof(Livre_s));

    std::fstream fichierClient;
    fichierClient.open(FILENAME_CLIENT, std::ios::in | std::ios::out | std::ios::binary);
    fichierClient.seekg(sizeof(Client_s) * client_id, std::ios::beg);
    fichierClient.read((char*)&client, sizeof(Client_s));

    if (client.NombrePretActif < 3 && livre.Loue == false) {
        
        livre.Loue = true;
        fichierLivre.seekp(sizeof(Livre_s) * livre_id, std::ios::beg);
        fichierLivre.write((char*)&livre, sizeof(Livre_s));
        
        client.Prets[client.NombrePretActif].NumLivre = livre_id;
        client.Prets[client.NombrePretActif].DateLocation = location;
        client.Prets[client.NombrePretActif].DateRetourPrevu = retour;
        client.NombrePretActif++;

        fichierClient.seekp(sizeof(Client_s) * client_id, std::ios::beg);
        fichierClient.write((char*)&client, sizeof(Client_s));
        dateDeRetour = retour;
    }
    
    fichierClient.close();
    fichierLivre.close();

    return dateDeRetour;
}


float Retour(int client_id, int livre_position, Date_s retour) {
    // livre_position représente la position du livre à retourner dans le tableau du client
    Livre_s livre = {};
    Pret_s pretNull = { -1,{},{} };
    Client_s client = {};

    std::fstream fichierClient;
    std::fstream fichierLivre;
    float MontantTotale = 0;

    fichierClient.open(FILENAME_CLIENT, std::ios::in | std::ios::out | std::ios::binary);
    fichierClient.seekg(sizeof(Client_s) * client_id, std::ios::beg);
    fichierClient.read((char*)&client, sizeof(Client_s));

    fichierLivre.open(FILENAME_LIVRE, std::ios::in | std::ios::out | std::ios::binary);
    fichierLivre.seekg(sizeof(Livre_s) * client.Prets[livre_position].NumLivre, std::ios::beg);
    fichierLivre.read((char*)&livre, sizeof(Livre_s));

    livre.Loue = false;

    if (client.NombrePretActif < 0) {
        client.NombrePretActif = 0;
    }

    fichierLivre.seekp(sizeof(Livre_s) * client.Prets[livre_position].NumLivre, std::ios::beg);
    fichierLivre.write((char*)&livre, sizeof(Livre_s));

    for (int i = livre_position; i < client.NombrePretActif - 1; i++) {
        client.Prets[i] = client.Prets[i + 1];
    }
   
      int nbJoursRetard = NombreJours(client.Prets[livre_position].DateRetourPrevu, retour);
      MontantTotale += (nbJoursRetard * 5) * 1.14975;

    client.Prets[client.NombrePretActif - 1] = pretNull;
    client.NombrePretActif--;

    fichierClient.seekp(sizeof(Client_s) * client_id, std::ios::beg);
    fichierClient.write((char*)&client, sizeof(Client_s));

    fichierClient.close();
    fichierLivre.close();

    return MontantTotale;
}


void RetourMain() {
    int client_id;
    int livre_position;
    Date_s retour = Aujourdhui();

    gotoxy(0, 20);

    ecrire << "Entrez le numéro de la personne qui retourne un livre :";
    lire >> client_id; ecrire << std::endl;
    ecrire << "Entrez le numéro du livre à retourné :";
    lire >> livre_position; ecrire << std::endl;

    Retour(client_id, livre_position, retour);
    ecrire << "Le retour a été effectué." << std::endl;
}

void LocationMain() {
    int client_id;
    int livre_id;
    Date_s location = Aujourdhui(), retour = AjouterJours(location, 15);

    ecrire << "Entrez le numéro de la personne qui emprunte : " ;
    lire >> client_id; ecrire << std::endl;
    ecrire << "Entrez le numéro du livre à emprunté :";
    lire >> livre_id; ecrire << std::endl;
    Location(client_id, livre_id);
    ecrire << "La location a été réalisé. Le retour est prévus pour le." << retour.jour << "/" << retour.mois << "/" << retour.annee << std::endl;
}