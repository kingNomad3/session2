package projetchansons;

public class Chanson {

    private String nom;
    private String nomArtiste;
    private String duree;
    private String genre;

    public Chanson()
    {
        this.nom = "";
        this.nomArtiste = "";
        this.duree = "";
        this.genre ="";
    }

    public Chanson ( String nom, String nomArtiste,  String genre, String duree )
    {
        this.nom = nom;
        this.nomArtiste = nomArtiste;
        this.duree = duree;
        this.genre = genre;
    }

    public String getNom (){
        return nom;
    }

    public String getNomArtiste (){
        return nomArtiste;
    }

    public String getDuree(){
        return duree;
    }

    public String getGenre(){
        return genre;
    }


    public void setNom ( String nom ){
        this.nom = nom;
    }

    public void setNomArtiste ( String nomArtiste ){
        this.nomArtiste = nomArtiste;
    }

    public void setDuree ( String duree ){
        this.duree = duree;
    }

    public void setGenre( String genre ){
        this.genre = genre;
    }

}
