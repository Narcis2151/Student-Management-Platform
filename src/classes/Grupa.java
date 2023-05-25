package classes;

import java.util.ArrayList;
import java.util.List;

public class Grupa {
    private int id_grupa;
    private int id_serie;
    private Serie serie;
    private List <Student> studenti;
    private List <Laborator> laboratoare;

    public Grupa(int id_grupa, int id_serie) {
        this.id_grupa = id_grupa;
        this.id_serie = id_serie;
        this.studenti = new ArrayList<Student>();
        this.laboratoare = new ArrayList<Laborator>();
    }
    
    public int getId_grupa() {
        return id_grupa;
    }
    public void setId_grupa(int id_grupa) {
        this.id_grupa = id_grupa;
    }
    public int getId_serie() {
        return id_serie;
    }
    public void setId_serie(int id_serie) {
        this.id_serie = id_serie;
    }
    public List<Student> getStudenti() {
        return studenti;
    }
    public void setStudenti(List<Student> studenti) {
        this.studenti = studenti;
    }
    public List<Laborator> getLaboratoare() {
        return laboratoare;
    }
    public void setLaboratoare(List<Laborator> laboratoare) {
        this.laboratoare = laboratoare;
    }
    public void addStudent(Student student) {
        studenti.add(student);
    }
    public void removeStudent(Student student) {
        studenti.remove(student);
    }
    public void addLaborator(Laborator laborator) {
        laboratoare.add(laborator);
    }
    public Serie getSerie() {
        return serie;
    }
    public void setSerie(Serie serie) {
        this.serie = serie;
    }
    @Override
    public String toString() {
        return "Grupa " + id_grupa + "\n id_serie=" + id_serie  + "\n numar de studenti=" + studenti.size()
                + "\n numar de laboratoare=" + laboratoare.size() + "\n";
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Grupa) {
            Grupa g = (Grupa) obj;
            if (g.getId_grupa() == this.id_grupa) {
                return true;
            }
        }
        return false;
    }
}
