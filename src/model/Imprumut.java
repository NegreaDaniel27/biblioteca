package model;

public class Imprumut {

    private int id;
    private String dataImprumut;
    private String dataReturn;

    public Imprumut() {
    }

    public Imprumut(int id, String dataImprumut, String dataReturn) {
        this.id = id;
        this.dataImprumut = dataImprumut;
        this.dataReturn = dataReturn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataImprumut() {
        return dataImprumut;
    }

    public void setDataImprumut(String dataImprumut) {
        this.dataImprumut = dataImprumut;
    }

    public String getDataReturn() {
        return dataReturn;
    }

    public void setDataReturn(String dataReturn) {
        this.dataReturn = dataReturn;
    }

    @Override
    public String toString() {
        return "Imprumut{" +
                "id=" + id +
                ", dataImprumut='" + dataImprumut + '\'' +
                ", dataReturn='" + dataReturn + '\'' +
                '}';
    }
}
