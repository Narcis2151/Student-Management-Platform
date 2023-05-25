package classes;

public class Laborator extends Materie{

    int id_grupa;
    int id_profesor;
    String limbajProgramare;
    String lab;
    Grupa grupa;
    Profesor profesor;

    public Laborator(String nume, int numar_credite, int numar_ore, int id_grupa, int id_profesor, String limbajProgramare, String lab) {
        super(nume, numar_credite, numar_ore);
        this.id_grupa = id_grupa;
        this.id_profesor = id_profesor;
        this.limbajProgramare = limbajProgramare;
        this.lab = lab;
    }

    public int getId_grupa() {
        return id_grupa;
    }
    public void setId_grupa(int id_grupa) {
        this.id_grupa = id_grupa;
    }
    public int getId_profesor() {
        return id_profesor;
    }
    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }
    public String getLimbajProgramare() {
        return limbajProgramare;
    }
    public void setLimbajProgramare(String limbajProgramare) {
        this.limbajProgramare = limbajProgramare;
    }
    public String getLab() {
        return lab;
    }
    public void setLab(String lab) {
        this.lab = lab;
    }
    public Grupa getGrupa() {
        return grupa;
    }
    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }
    public Profesor getProfesor() {
        return profesor;
    }
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    @Override
    public String toString() {
        return "Laborator de " + super.nume + ", id profesor=" + id_profesor + ", grupa=" + id_grupa;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Laborator) {
            Laborator laborator = (Laborator) obj;
            return this.nume == laborator.nume;
        }
        return false;
    }
}
