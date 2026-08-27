import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileReaderUtil {

    public static List<PatientRecord> loadRecords(String folderPath) {

        List<PatientRecord> records = new ArrayList<>();

        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Patient records folder not found!");
            return records;
        }

        File[] files = folder.listFiles();

        if (files == null) {
            return records;
        }

        for (File file : files) {

            if (file.isFile() && file.getName().endsWith(".txt")) {

                try {

                    String content = Files.readString(file.toPath());

                    String patientId =
                            file.getName().replace(".txt", "");

                    PatientRecord record =
                            new PatientRecord(
                                    patientId,
                                    file.getName(),
                                    content
                            );

                    records.add(record);

                } catch (IOException e) {

                    System.out.println(
                            "Error reading: " + file.getName()
                    );
                }
            }
        }

        return records;
    }
}