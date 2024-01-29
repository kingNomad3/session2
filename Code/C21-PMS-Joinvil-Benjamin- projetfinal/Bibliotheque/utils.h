#pragma once

#include "type.h"

void LireChaineC(char[], const int);

Date_s Aujourdhui();;

Date_s AjouterJours(Date_s, int);

int NombreJours(Date_s, Date_s);

void io_clean();

static bool Bissextile(int);

static int NbreJoursMois(int, int);


Date_s AjouterJours(Date_s, int);

static int nbJourBissextile(int);

static int correction(Date_s, Date_s);

int NombreJours(Date_s, Date_s);

bool LivreEquals(const Livre_s, const Livre_s);

bool AdresseEqual(const Adresse_s, const Adresse_s);

bool DateEqual(const Date_s, const Date_s);

bool PretEqual(const Pret_s, const Pret_s);

bool ClientEquals(const Client_s, const Client_s);