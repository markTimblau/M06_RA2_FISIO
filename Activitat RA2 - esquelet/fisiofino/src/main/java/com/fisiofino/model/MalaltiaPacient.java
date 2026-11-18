package com.fisiofino.model;

public class MalaltiaPacient {

    private int id_diagnosis;
    private int id_patient;
    private int snomed_code;
    private String status;
    private String treatment;

    public MalaltiaPacient(){ 
    }

    public MalaltiaPacient(int id_diagnosis, int id_patient, int snomed_code, String status, String treatment){ 
        this.id_diagnosis = id_diagnosis;
        this.id_patient = id_patient;
        this.snomed_code = snomed_code;
        this.status = status;
        this.treatment = treatment;
    }

    public int getId_diagnosis() {
        return id_diagnosis;
    }

    public void setId_diagnosis(int id_diagnosis) {
        this.id_diagnosis = id_diagnosis;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public int getSnomed_code() {
        return snomed_code;
    }

    public void setSnomed_code(int snomed_code) {
        this.snomed_code = snomed_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "MalaltiaPacient [id_diagnosis=" + id_diagnosis + ", id_patient=" + id_patient + ", snomed_code="
                + snomed_code + ", status=" + status + ", treatment=" + treatment + "]";
    }
}
