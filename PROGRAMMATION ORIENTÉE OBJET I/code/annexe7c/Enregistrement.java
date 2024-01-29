package packageannexe7;

    public class Enregistrement {

        private String nomUsager;
        private String motPasse;
        private String adresseCourriel;

        public Enregistrement(String nomUsager, String motPasse, String adresseCourriel){
            this.nomUsager = nomUsager;
            this.motPasse = motPasse;
            this.adresseCourriel = adresseCourriel;

        }

        public String getNomUsager(){
            return nomUsager;
        }
        public String getMotPasse(){
            return motPasse;
        }

        public String getAdresseCourriel(){
            return adresseCourriel;
        }

      @Override

        public boolean equals(Object obj){
            if(!(obj instanceof Enregistrement))
                return false;
            return true;
        }

}
