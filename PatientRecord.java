public class PatientRecord {

    private String patientId;
    private String fileName;
    private String content;

    public PatientRecord(String patientId, String fileName, String content) {
        this.patientId = patientId;
        this.fileName = fileName;
        this.content = content;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContent() {
        return content;
    }
}