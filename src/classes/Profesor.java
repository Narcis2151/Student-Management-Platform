package classes;

import java.util.ArrayList;
import java.util.List;


public class Profesor{
    static int nrProfesori;
    int id_profesor;
    String nume;
    String titlu;
    double salariu;
    List<Curs> cursuri;
    List<Laborator> laboratoare;

    static {
        nrProfesori = 0;
    }

    public Profesor(String nume, String titlu, double salariu) {
        this.id_profesor = ++nrProfesori;
        this.nume = nume;
        this.titlu = titlu;
        this.salariu = salariu;
        this.cursuri = new ArrayList<Curs>();
        this.laboratoare = new ArrayList<Laborator>();
    }

    public int getId_profesor() {
        return id_profesor;
    }
    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public String getTitlu() {
        return titlu;
    }
    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }
    public double getSalariu() {
        return salariu;
    }
    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }
    public List<Curs> getCursuri() {
        return cursuri;
    }
    public void setCursuri(List<Curs> cursuri) {
        this.cursuri = cursuri;
    }
    public List<Laborator> getLaboratoare() {
        return laboratoare;
    }
    public void setLaboratoare(List<Laborator> laboratoare) {
        this.laboratoare = laboratoare;
    }
    public void addCurs(Curs curs) {
        cursuri.add(curs);
    }
    public void addLaborator(Laborator laborator) {
        laboratoare.add(laborator);
    }
    public void removeCurs(Curs curs) {
        cursuri.remove(curs);
    }
    public void removeLaborator(Laborator laborator) {
        laboratoare.remove(laborator);
    }
    
    @Override
    public String toString() {
        return "Profesor: " + id_profesor + "\n nume=" + nume + "\n salariu=" + salariu + "\n numar de cursuri=" + cursuri.size() + "\n numar de laboratoare=" + laboratoare.size() + "\n";
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Profesor) {
            Profesor profesor = (Profesor) obj;
            return this.nume.equals(profesor.nume);
        }
        return false;
    }
}
