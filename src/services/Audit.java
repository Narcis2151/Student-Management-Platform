package services;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {
    private static Audit instance;
    FileWriter fileWriter;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    
    private Audit() {
        try {
            fileWriter = new FileWriter("src\\services\\Audit.csv", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Audit getInstance() {
        if (instance == null) {
            instance = new Audit();
        }
        return instance;
    }

    public void write (String actionName) {
        try {
            fileWriter.append(actionName);
            fileWriter.append(",");
            fileWriter.append(dtf.format(LocalDateTime.now()));
            fileWriter.append("\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
