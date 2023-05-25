package classes;

public class Materie {
    String nume;
    int numar_credite;
    int numar_ore;

    public Materie(String nume, int numar_credite, int numar_ore) {
        this.nume = nume;
        this.numar_credite = numar_credite;
        this.numar_ore = numar_ore;
    }

    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public int getNumar_credite() {
        return numar_credite;
    }
    public void setNumar_credite(int numar_credite) {
        this.numar_credite = numar_credite;
    }
    public int getNumar_ore() {
        return numar_ore;
    }
    public void setNumar_ore(int numar_ore) {
        this.numar_ore = numar_ore;
    }

    @Override
    public String toString() {
        return "Materia: " + nume + "\n numar_credite=" + numar_credite + "\n numar_ore=" + numar_ore + "\n";
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Materie) {
            Materie materie = (Materie) obj;
            return this.nume.equals(materie.nume);
        }
        return false;
    }
}
