package classes;

public class Examen {
    Curs curs;
    Student student;
    double nota;
    
    public Examen(Curs curs, Student student, double nota) {
        this.curs = curs;
        this.student = student;
        this.nota = nota;
    }

    public Curs getCurs() {
        return curs;
    }
    public void setCurs(Curs curs) {
        this.curs = curs;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
    @Override
    public String toString() {
        return "Examen la materia: " + curs + "\n nota=" + nota + "\n student=" + student.getNume() + "\n";
    }
}
