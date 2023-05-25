package services;
import java.util.List;
import java.util.Scanner;

import repositories.*;
import classes.*;


public class Menu {
    private static Menu instance;
    private static Scanner scanner;
    private static Audit audit = Audit.getInstance();
    private StudentRepository studentRepository;
    private GrupaRepository grupaRepository;
    private SerieRepository serieRepository;
    private CursRepository cursRepository;
    private ProfesorRepository profesorRepository;
    private LaboratorRepository laboratorRepository;
    private MaterieRepository materieRepository;
    private List <Serie> serii;
    private List <Grupa> grupe;
    private List <Student> studenti;
    private List <Curs> cursuri;
    private List <Profesor> profesori;
    private List <Laborator> laboratoare;
    private List <Materie> materii;

    private Menu() {
        scanner = new Scanner(System.in);
        studentRepository = StudentRepository.getInstance();
        grupaRepository = GrupaRepository.getInstance();
        serieRepository = SerieRepository.getInstance();
        cursRepository = CursRepository.getInstance();
        profesorRepository = ProfesorRepository.getInstance();
        laboratorRepository = LaboratorRepository.getInstance();
        materieRepository = MaterieRepository.getInstance();
        serii = serieRepository.getAll();
        grupe = grupaRepository.getAll();
        studenti = studentRepository.getAll();
        cursuri = cursRepository.getAll();
        profesori = profesorRepository.getAll();
        laboratoare = laboratorRepository.getAll();
        materii = materieRepository.getAll();
        add_info();
    }

    private void add_info() {
        for (int i=0; i<serii.size(); i++){
            Serie serie = serii.get(i);
            for (int j=0; j<grupe.size(); j++){
                Grupa grupa = grupe.get(j);
                if (grupa.getId_serie() == serie.getId_serie()){
                    serie.addGrupa(grupa);
                    grupa.setSerie(serie);
                    for (int k=0; k<studenti.size(); k++){
                        Student student = studenti.get(k);
                        if (student.getId_grupa() == grupa.getId_grupa()){
                            grupa.addStudent(student);
                            student.setGrupa(grupa);
                            serie.addStudent(student);
                        }
                    }
                    for (int l=0; l<laboratoare.size(); l++){
                        Laborator laborator = laboratoare.get(l);
                        if (laborator.getId_grupa() == grupa.getId_grupa()){
                            grupa.addLaborator(laborator);
                            laborator.setGrupa(grupa);
                            for (int p=0; p<profesori.size(); p++){
                                Profesor profesor = profesori.get(p);
                                if (profesor.getId_profesor() == laborator.getId_profesor()){
                                    laborator.setProfesor(profesor);
                                    profesor.addLaborator(laborator);
                                }
                            }   
                        }
                    }
                }
            }
            for (int c=0; c<cursuri.size(); c++)
            {
                Curs curs = cursuri.get(c);
                if (curs.getId_serie() == serie.getId_serie()){
                    serie.addCurs(curs);
                    curs.setSerie(serie);
                    for (int p=0; p<profesori.size(); p++){
                        Profesor profesor = profesori.get(p);
                        if (profesor.getId_profesor() == curs.getId_profesor()){
                            curs.setProfesor(profesor);
                            profesor.addCurs(curs);
                        }
                    }
                }
            }
        }
    }
    
    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("=== MENU ===");
            System.out.println("1. Adauga Serie");
            System.out.println("2. Afiseaza Serii");
            System.out.println("3. Adauga grupa");
            System.out.println("4. Afiseaza grupe");
            System.out.println("5. Afiseaza informatii facultate");
            System.out.println("6. Adauga student");
            System.out.println("7. Afiseaza studenti");
            System.out.println("8. Transfera student");
            System.out.println("9. Exmatriculeaza student");
            System.out.println("10. Adauga materie");
            System.out.println("11. Afiseaza materii");
            System.out.println("12. Adauga profesor");
            System.out.println("13. Afiseaza profesori");
            System.out.println("14. Mareste salariu profesor");
            System.out.println("15. Concediaza profesor");
            System.out.println("16. Adauga curs");
            System.out.println("17. Afiseaza cursuri");
            System.out.println("18. Adauga laborator");
            System.out.println("19. Afiseaza laboratoare");
            System.out.println("20. Schimbare profesor laborator");
            System.out.println("21. Schimbare profesor curs");
            System.out.println("22. SESIUNE!!!");
            System.out.println("23. Striga catalogul");
            System.out.println("0. Exit");
            System.out.print("Alegeti Varianta: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    audit.write("addSerie");
                    addSerie();
                    break;
                case 2:
                    audit.write("showSerii");
                    showSerii();
                    break;
                case 3:
                    audit.write("addGrupa");
                    addGrupa();
                    break;
                case 4:
                    audit.write("showGrupe");
                    showGrupe();
                    break;
                case 5:
                    audit.write("showInfo");
                    showInfo();
                    break;
                case 6:
                    audit.write("addStudent");
                    addStudent();
                    break;
                case 7:
                    audit.write("showStudents");
                    showStudents();
                    break;
                case 8:
                    audit.write("updateStudent");
                    updateStudent();
                    break;
                case 9:
                    audit.write("deleteStudent");
                    deleteStudent();
                    break;
                case 10:
                    audit.write("addMaterie");
                    addMaterie();
                    break;
                case 11:
                    audit.write("showMaterii");
                    showMaterii();
                    break;
                case 12:
                    audit.write("addProfesor");
                    addProfesor();
                    break;
                case 13:
                    audit.write("showProfesori");
                    showProfesori();
                    break;
                case 14:
                    audit.write("updateProfesor");
                    updateProfesor();
                    break;
                case 15:
                    audit.write("deleteProfesor");
                    deleteProfesor();
                    break;
                case 16:
                    audit.write("addCurs");
                    addCurs();
                    break;
                case 17:
                    audit.write("showCursuri");
                    showCursuri();
                    break;
                case 18:
                    audit.write("addLaborator");
                    addLaborator();
                    break;
                case 19:
                    audit.write("showLaboratoare");
                    showLaboratoare();
                    break;
                case 20:    
                    audit.write("updateLaborator");
                    updateLaborator();
                    break;
                case 21:
                    audit.write("updateCurs");
                    updateCurs();
                    break;
                case 22:
                    addExamen();
                    audit.write("addExamen");
                    break;
                case 23:
                    showCatalog();
                    audit.write("showCatalog");
                    break;
                case 0:
                    running = false;
                    audit.write("exit");
                    break;
                default:
                    System.out.println("Invalid, mai incercati!");
                    break;
            }
        }
    }

    private void addSerie() {
        System.out.println("Introduceti id-ul seriei: ");
        int idSerie = scanner.nextInt();
        System.out.println("Introduceti semestrul: ");
        int semestru = scanner.nextInt();
        Serie serie = new Serie(idSerie, semestru);
        SerieRepository.getInstance().add(serie);
        serii.add(serie);
    }

    private void showSerii() {
        for (Serie serie : serii) {
            System.out.println(serie);
        }
    }

    private void addGrupa() {
        System.out.println("Introduceti id-ul grupei: ");
        int idGrupa = scanner.nextInt();
        System.out.println("Introduceti id-ul seriei de care apartine: ");
        int idSerie = scanner.nextInt();
        Grupa grupa = new Grupa(idGrupa, idSerie);
        Serie serie = serieRepository.getById(idSerie);
        Serie serie_mod = serii.get(serii.indexOf(serie));
        serie_mod.addGrupa(grupa);
        serii.set(serii.indexOf(serie), serie_mod);
        grupa.setSerie(serie);
        grupaRepository.add(grupa);
        grupe.add(grupa);
    }

    private void showGrupe() {
        for (Grupa grupa : grupe) {
            System.out.println(grupa);
        }
    }

    private void showInfo() {
        System.out.println("Facultatea are " + serii.size() + " serii si " + grupe.size() + " grupe.");
        System.out.println("Serii: ");
        for (Serie serie : serii) {
            System.out.println(serie);
            for(Grupa grupa : serie.getGrupe()) {
                if (grupa.getId_serie() == serie.getId_serie()) {
                    System.out.println(grupa);
                }
            }
        }

    }

    private void addStudent() {
        System.out.println("Introduceti numele studentului: ");
        String nume = scanner.next();
        System.out.println("Introduceti id-ul grupei din care face parte: ");
        int idGrupa = scanner.nextInt();
        Student student = new Student(nume, idGrupa);
        Grupa grupa = grupaRepository.getById(idGrupa);
        Grupa grupa_mod = grupe.get(grupe.indexOf(grupa));
        Serie serie = serieRepository.getById(grupa.getId_serie());
        Serie serie_mod = serii.get(serii.indexOf(serie));
        grupa_mod.addStudent(student);
        serie_mod.addStudent(student);
        serii.set(serii.indexOf(serie), serie_mod);
        grupe.set(grupe.indexOf(grupa), grupa_mod);
        student.setGrupa(grupa);
        studentRepository.create(student);
        studenti.add(student);
    }
    
    private void showStudents() {
        for (Student student : studenti) {
            System.out.println(student);
        }
    }

    private void updateStudent() {
        System.out.println("Introduceti id-ul studentului: ");
        int idStudent = scanner.nextInt();
        System.out.println("Introduceti id-ul grupei in care se transfera: ");
        int idGrupaNoua = scanner.nextInt();
        Student student = studentRepository.getById(idStudent);
        Student student_mod = studenti.get(studenti.indexOf(student));

        Grupa grupa_veche = grupaRepository.getById(student.getId_grupa());
        Grupa grupa_veche_mod = grupe.get(grupe.indexOf(grupa_veche));
        grupa_veche_mod.removeStudent(student);

        Grupa grupa_noua = grupaRepository.getById(idGrupaNoua);
        Grupa grupa_noua_mod = grupe.get(grupe.indexOf(grupa_noua));
        grupa_noua_mod.addStudent(student);
        
        student_mod.setId_grupa(idGrupaNoua);
        student_mod.setGrupa(grupa_noua);
        studenti.set(studenti.indexOf(student), student_mod);
        grupe.set(grupe.indexOf(grupa_veche), grupa_veche_mod);
        grupe.set(grupe.indexOf(grupa_noua), grupa_noua_mod);
        studentRepository.update(student_mod);
    }

    private void deleteStudent(){
        System.out.println("Introduceti id-ul studentului: ");
        int idStudent = scanner.nextInt();
        Student student = studentRepository.getById(idStudent);
        Student student_mod = studenti.get(studenti.indexOf(student));
        Grupa grupa = grupaRepository.getById(student.getId_grupa());
        Grupa grupa_mod = grupe.get(grupe.indexOf(grupa));
        grupa_mod.removeStudent(student);
        studenti.remove(studenti.indexOf(student_mod));
        studentRepository.delete(student_mod.getNrMatricol());
    }

    private void addMaterie() {
        System.out.println("Introduceti numele materiei: ");
        String nume = scanner.next();
        System.out.println("Introduceti numarul de credite: ");
        int nrCredite = scanner.nextInt();
        System.out.println("Introduceti numarul de ore pe saptamana: ");
        int nrOre = scanner.nextInt();
        Materie materie = new Materie(nume, nrCredite, nrOre);
        MaterieRepository.getInstance().add(materie);
        materii.add(materie);
    }

    private void showMaterii() {
        for (Materie materie : materii) {
            System.out.println(materie);
        }
    }

    private void addProfesor() {
        System.out.println("Introduceti numele profesorului: ");
        String nume = scanner.next();
        System.out.println("Introduceti titlul profesorului: ");
        String titlu = scanner.next();
        System.out.println("Introduceti salariul profesorului: ");
        double salariu = scanner.nextDouble();
        Profesor profesor = new Profesor(nume, titlu, salariu);
        profesorRepository.add(profesor);
        profesori.add(profesor);
    }

    private void showProfesori() {
        for (Profesor profesor : profesori) {
            System.out.println(profesor);
        }
    }

    private void updateProfesor() {
        System.out.println("Introduceti id-ul profesorului: ");
        int idProfesor = scanner.nextInt();
        System.out.println("Introduceti noul salariu: ");
        double salariuNou = scanner.nextDouble();
        Profesor profesor = profesorRepository.getById(idProfesor);
        Profesor profesor_mod = profesori.get(profesori.indexOf(profesor));
        profesor_mod.setSalariu(salariuNou);
        profesori.set(profesori.indexOf(profesor), profesor_mod);
        profesorRepository.update(profesor_mod);
    }

    private void deleteProfesor(){
        System.out.println("Introduceti id-ul profesorului: ");
        int idProfesor = scanner.nextInt();
        Profesor profesor = profesorRepository.getById(idProfesor);
        Profesor profesor_mod = profesori.get(profesori.indexOf(profesor));
        profesori.remove(profesori.indexOf(profesor_mod));
        profesorRepository.delete(profesor_mod.getId_profesor());
    }

    private void addCurs() {
        showSerii();
        System.out.println("Introduceti id-ul seriei: ");
        int idSerie = scanner.nextInt();
        showProfesori();
        System.out.println("Introduceti id-ul profesorului: ");
        int idProfesor = scanner.nextInt();
        showMaterii();
        System.out.println("Introduceti numele materiei: ");
        String nume = scanner.next();
        System.out.println("Introduceti modul de evaluare: ");
        String modEvaluare = scanner.next();
        System.out.println("Introduceti sala: ");
        String sala = scanner.next();        
        Materie materie = materieRepository.getByNume(nume);
        Curs curs = new Curs(materie.getNume(), materie.getNumar_credite(), materie.getNumar_ore(), idSerie, idProfesor, modEvaluare, sala);
        Profesor profesor = profesorRepository.getById(idProfesor);
        Profesor profesor_mod = profesori.get(profesori.indexOf(profesor));
        Serie serie = serieRepository.getById(idSerie);
        Serie serie_mod = serii.get(serii.indexOf(serie));
        serie_mod.addCurs(curs);
        serii.set(serii.indexOf(serie), serie_mod);
        profesor_mod.addCurs(curs);
        profesori.set(profesori.indexOf(profesor), profesor_mod);
        cursRepository.add(curs);
        cursuri.add(curs);
    }

    private void showCursuri() {
        for (Curs curs : cursuri) {
            System.out.println(curs);
        }
    }

    private void addLaborator() {
        showGrupe();
        System.out.println("Introduceti id-ul grupei: ");
        int idGrupa = scanner.nextInt();
        showProfesori();
        System.out.println("Introduceti id-ul profesorului: ");
        int idProfesor = scanner.nextInt();
        showMaterii();
        System.out.println("Introduceti numele materiei: ");
        String nume = scanner.next();
        System.out.println("Introduceti limbajul de programare studiat: ");
        String limbajProgramare = scanner.next();
        System.out.println("Introduceti laboratorul in care se va tine: ");
        String sala = scanner.next();        
        Materie materie = materieRepository.getByNume(nume);
        Laborator laborator = new Laborator(materie.getNume(), materie.getNumar_credite(), materie.getNumar_ore(), idGrupa, idProfesor, limbajProgramare, sala);
        Profesor profesor = profesorRepository.getById(idProfesor);
        Profesor profesor_mod = profesori.get(profesori.indexOf(profesor));
        Grupa grupa = grupaRepository.getById(idGrupa);
        Grupa grupa_mod = grupe.get(grupe.indexOf(grupa));
        grupa_mod.addLaborator(laborator);
        grupe.set(grupe.indexOf(grupa), grupa_mod);
        profesor_mod.addLaborator(laborator);
        profesori.set(profesori.indexOf(profesor), profesor_mod);
        laboratoare.add(laborator);
        laboratorRepository.add(laborator);
        
    }

    private void showLaboratoare() {
        for (Laborator laborator : laboratoare) {
            System.out.println(laborator);
        }
    }

    private void updateLaborator() {
        showLaboratoare();
        System.out.println("Introduceti numele laboratorului: ");
        String numeLaborator = scanner.next();
        showProfesori();
        System.out.println("Introduceti id-ul profesorului nou: ");
        int idProfesor = scanner.nextInt();
    
        Laborator laborator = laboratorRepository.getById(numeLaborator);
        Laborator laborator_mod = laboratoare.get(laboratoare.indexOf(laborator));

        Profesor profesor_vechi = profesorRepository.getById(laborator.getId_profesor());
        Profesor profesor_vechi_mod = profesori.get(profesori.indexOf(profesor_vechi));
        profesor_vechi_mod.removeLaborator(laborator);

        Profesor profesor_nou = profesorRepository.getById(idProfesor);
        Profesor profesor_nou_mod = profesori.get(profesori.indexOf(profesor_nou));
        profesor_nou_mod.addLaborator(laborator);

        laborator_mod.setId_profesor(idProfesor);
        laborator_mod.setProfesor(profesor_nou);
        laboratoare.set(laboratoare.indexOf(laborator), laborator_mod);

        profesori.set(profesori.indexOf(profesor_vechi), profesor_vechi_mod);
        profesori.set(profesori.indexOf(profesor_nou), profesor_nou_mod);

        laboratorRepository.update(laborator_mod);
    }

    private void updateCurs() {
        showCursuri();
        System.out.println("Introduceti numele cursului: ");
        String numeCurs = scanner.next();
        showProfesori();
        System.out.println("Introduceti id-ul profesorului nou: ");
        int idProfesor = scanner.nextInt();

        Curs curs = cursRepository.getById(numeCurs);
        Curs curs_mod = cursuri.get(cursuri.indexOf(curs));

        Profesor profesor_vechi = profesorRepository.getById(curs.getId_profesor());
        Profesor profesor_vechi_mod = profesori.get(profesori.indexOf(profesor_vechi));
        profesor_vechi_mod.removeCurs(curs);

        Profesor profesor_nou = profesorRepository.getById(idProfesor);
        Profesor profesor_nou_mod = profesori.get(profesori.indexOf(profesor_nou));
        profesor_nou_mod.addCurs(curs);

        curs_mod.setId_profesor(idProfesor);
        curs_mod.setProfesor(profesor_nou);
        cursuri.set(cursuri.indexOf(curs), curs_mod);

        profesori.set(profesori.indexOf(profesor_vechi), profesor_vechi_mod);
        profesori.set(profesori.indexOf(profesor_nou), profesor_nou_mod);

        cursRepository.update(curs_mod);
    }

    private void addExamen() {
        showCursuri();
        System.out.println("Introduceti numele cursului: ");
        String numeCurs = scanner.next();
        Curs curs = cursRepository.getById(numeCurs);
        for (int i=0; i<studenti.size(); i++)
        {
            Student student = studenti.get(i);
            int id_grupa = student.getId_grupa();
            Grupa grupa = grupaRepository.getById(id_grupa);
            int id_serie = grupa.getId_serie();
            if (id_serie == curs.getId_serie()){
                System.out.println("Introduceti nota studentului " + student.getNume() + ": ");
                double nota = scanner.nextDouble();
                student.addExamen(new Examen(curs, student, nota));
                student.setMedie(student.getMedie() + nota / student.getExamene().size() + 1);
                studenti.set(i, student);
            }
        }
    }

    private void showCatalog() {
        for (Serie serie : serii) {
            System.out.println(serie);
            for (Student student : serie.getStudenti()) {
                System.out.println(student);
            }
        }
    }
}
