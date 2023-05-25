package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Serie {
    int id_serie;
    int semestru;
    List<Grupa> grupe;
    TreeSet<Student> studenti;
    List<Curs> cursuri;

    public Serie(int id_serie, int semestru) {
        this.id_serie = id_serie;
        this.semestru = semestru;
        this.grupe = new ArrayList<Grupa>();
        this.studenti = new TreeSet<Student>();
        this.cursuri = new ArrayList<Curs>();
    }
    
    public int getId_serie() {
        return id_serie;
    }
    public void setId_serie(int id_serie) {
        this.id_serie = id_serie;
    }
    public int getSemestru() {
        return semestru;
    }
    public void setSemestru(int semestru) {
        this.semestru = semestru;
    }
    public List<Grupa> getGrupe() {
        return grupe;
    }
    public void setGrupe(List<Grupa> grupe) {
        this.grupe = grupe;
    }
    public TreeSet<Student> getStudenti() {
        return studenti;
    }
    public void setStudenti(TreeSet<Student> studenti) {
        this.studenti = studenti;
    }
    public List<Curs> getCursuri() {
        return cursuri;
    }
    public void setCursuri(List<Curs> cursuri) {
        this.cursuri = cursuri;
    }
    public void addGrupa(Grupa grupa) {
        grupe.add(grupa);
    }
    public void addStudent(Student student) {
        studenti.add(student);
    }
    public void addCurs(Curs curs) {
        cursuri.add(curs);
    }

    @Override
    public String toString() {
        return "Serie " + id_serie + "\n semestru=" + semestru + "\n grupe=" + grupe.size() + "\n numar de studenti=" + studenti.size()
                + "\n numar de cursuri=" + cursuri.size() + "\n";
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Serie) {
            Serie serie = (Serie) obj;
            return this.id_serie == serie.id_serie;
        }
        return false;
    }
}
