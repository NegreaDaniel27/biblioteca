package model;

public class Genuri {
    private int id;
    private String denumire;

    public Genuri() {
    }

    public Genuri(int id) {
        this.id = id;
    }

    public Genuri(String denumire) {
        this.denumire = denumire;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Genuri{" +
                "id='" + id + '\'' +
                ", denumire='" + denumire + '\'' +
                '}';
    }
}
