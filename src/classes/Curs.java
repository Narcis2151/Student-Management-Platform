package classes;


public class Curs extends Materie{
    int id_serie;
    int id_profesor;
    String modEvaluare;
    String sala;
    Serie serie;
    Profesor profesor;

    public Curs(String nume, int numar_credite, int numar_ore, int id_serie, int id_profesor, String modEvaluare, String sala) {
        super(nume, numar_credite, numar_ore);
        this.id_serie = id_serie;
        this.id_profesor = id_profesor;
        this.modEvaluare = modEvaluare;
        this.sala = sala;
    }

    public int getId_serie() {
        return id_serie;
    }
    public void setId_serie(int id_serie) {
        this.id_serie = id_serie;
    }
    public int getId_profesor() {
        return id_profesor;
    }
    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }
    public String getModEvaluare() {
        return modEvaluare;
    }
    public void setModEvaluare(String modEvaluare) {
        this.modEvaluare = modEvaluare;
    }
    public String getSala() {
        return sala;
    }
    public void setSala(String sala) {
        this.sala = sala;
    }
    public Serie getSerie() {
        return serie;
    }
    public void setSerie(Serie serie) {
        this.serie = serie;
    }
    public Profesor getProfesor() {
        return profesor;
    }
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    @Override
    public String toString() {
        return "Curs de " + super.nume + ", id profesor=" + id_profesor + ", serie=" + id_serie;
    }
}
