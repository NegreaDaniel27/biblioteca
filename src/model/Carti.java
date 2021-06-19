package model;

public class Carti {

    private int id;
    private String denumire;
    private String editura;
    private String anAparitie;
    private Autor autor;
    private Genuri genuri;

    public Carti() {
    }

    public Carti(int id, String denumire, String editura, String anAparitie) {
        this.id = id;
        this.denumire = denumire;
        this.editura = editura;
        this.anAparitie = anAparitie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    public String getAnAparitie() {
        return anAparitie;
    }

    public void setAnAparitie(String anAparitie) {
        this.anAparitie = anAparitie;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Genuri getGenuri() {
        return genuri;
    }

    public void setGenuri(Genuri genuri) {
        this.genuri = genuri;
    }

    @Override
    public String toString() {
        return "Carti{" +
                "id=" + id +
                ", denumire='" + denumire + '\'' +
                ", editura='" + editura + '\'' +
                ", anAparitie='" + anAparitie + '\'' +
                ", autor=" + autor +
                ", genuri=" + genuri +
                '}';
    }

}

