package Model;

public class Car {
    private String carID;
    private String mark;
    private String model;
    private String yearOfManufacture;
    private boolean isCarRented;

    public Car() {
    }

    public Car(String carID, String mark, String model, String yearOfManufacture, boolean isCarRented) {
        this.carID = carID;
        this.mark = mark;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.isCarRented = isCarRented;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public boolean isCarRented() {
        return isCarRented;
    }

    public void setCarRented(boolean carRented) {
        isCarRented = carRented;
    }
}
