package fr.topguns.inventorymanagementback.models;


public enum Status {
    PENDING("En cours"),
    VALIDATE("Validée"),
    REJECT("Rejetée");

    private  String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
