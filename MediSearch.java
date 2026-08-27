import java.util.*;

public class MediSearch {

    public static void main(String[] args) {

        String folderPath = "patient_records";

        List<PatientRecord> records =
                FileReaderUtil.loadRecords(folderPath);

        if (records.isEmpty()) {
            System.out.println("No patient records found.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.println("================================");
            System.out.println("          MEDI SEARCH");
            System.out.println("================================");
            System.out.println("1. Search Patient Records");
            System.out.println("2. Display All Records");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                System.out.print(
                        "Enter medical term or phrase: "
                );

                String query = scanner.nextLine();

                boolean found = false;

                System.out.println();
                System.out.println("Search Results:");
                System.out.println("-----------------------------");

                for (PatientRecord record : records) {

                    boolean match =
                            KMP.search(
                                    record.getContent(),
                                    query
                            );

                    if (match) {

                        System.out.println(
                                "MATCH FOUND -> "
                                + record.getFileName()
                        );

                        found = true;
                    }
                }

                if (!found) {
                    System.out.println(
                            "No matching patient records found."
                    );
                }

            } else if (choice == 2) {

                System.out.println();
                System.out.println("Patient Records:");
                System.out.println("-----------------------------");

                for (PatientRecord record : records) {

                    System.out.println(
                            record.getFileName()
                    );
                }

            } else if (choice == 3) {

                System.out.println(
                        "Thank you for using Medi Search."
                );

                break;

            } else {

                System.out.println(
                        "Invalid choice."
                );
            }
        }

        scanner.close();
    }
}