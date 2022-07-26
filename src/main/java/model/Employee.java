package model;

public class Employee {
    //Khai bao thuoc tinh
    private int id;
    private String fullName;
    private String email;
    private int hourWorkPerDay;
    private int longWork;
    private double fixedSalary;
    private int outsideSeviceNumber;
    private double totalSalary;

    public Employee() {
        super();
    }

    public Employee(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public Employee(int id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public Employee(int id, String fullName, String email, int hourWorkPerDay, int longWork, double fixedSalary, int outsideSeviceNumber, double totalSalary) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.hourWorkPerDay = hourWorkPerDay;
        this.longWork = longWork;
        this.fixedSalary = fixedSalary;
        this.outsideSeviceNumber = outsideSeviceNumber;
        this.totalSalary = totalSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHourWorkPerDay() {
        return hourWorkPerDay;
    }

    public void setHourWorkPerDay(int hourWorkPerDay) {
        this.hourWorkPerDay = hourWorkPerDay;
    }

    public int getLongWork() {
        return longWork;
    }

    public void setLongWork(int longWork) {
        this.longWork = longWork;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public int getOutsideSeviceNumber() {
        return outsideSeviceNumber;
    }

    public void setOutsideSeviceNumber(int outsideSeviceNumber) {
        this.outsideSeviceNumber = outsideSeviceNumber;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", hourWorkPerDay=" + hourWorkPerDay +
                ", longWork=" + longWork +
                ", fixedSalary=" + fixedSalary +
                ", outsideSeviceNumber=" + outsideSeviceNumber +
                ", totalSalary=" + totalSalary +
                '}';
    }
}
