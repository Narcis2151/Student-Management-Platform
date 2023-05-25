package classes;

import java.util.ArrayList;
import java.util.List;


public class Student implements Comparable<Student> {
    static int nrStudenti;
    int nrMatricol;
    String nume;
    double medie;
    int id_grupa;
    Grupa grupa;
    ArrayList<Examen> examene;

    static {
        nrStudenti = 0;
    }
    public Student(String nume, int id_grupa) {
        this.nume = nume;
        this.id_grupa = id_grupa;
        this.medie = 0;
        this.nrMatricol = ++nrStudenti;
        examene = new ArrayList<Examen>();
    }
    public int getNrMatricol() {
        return nrMatricol;
    }
    public void setNrMatricol(int nrMatricol) {
        this.nrMatricol = nrMatricol;
    }
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public int getId_grupa() {
        return id_grupa;
    }
    public void setId_grupa(int id_grupa) {
        this.id_grupa = id_grupa;
    }
    public List<Examen> getExamene() {
        return examene;
    }
    public void setExamene(ArrayList<Examen> examene) {
        this.examene = examene;
    }
    public void addExamen(Examen examen) {
        examene.add(examen);
    }
    public double getMedie() {
        return medie;
    }
    public void setMedie(double medie) {
        this.medie = medie;
    }
    public Grupa getGrupa() {
        return grupa;
    }
    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }
    @Override
    public int compareTo(Student o) {
        return this.nrMatricol - o.nrMatricol;
    }

    @Override
    public String toString() {
        return "Studentul " + nrMatricol + "\n nume=" + nume + "\n medie=" + medie + "\n id_grupa=" + id_grupa
                + "\n numar de examene date=" + examene.size() + "\n";
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            return this.nrMatricol == student.nrMatricol;
        }
        return false;
    }
}

