package model.entity;



public class Employee {
    private int id_employee;
    private String employeeName;
    private String employeeFamily;
    private String employeeCode;
    private String birthDate;
    private Unit unit;

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeFamily() {
        return employeeFamily;
    }

    public void setEmployeeFamily(String employeeFamily) {
        this.employeeFamily = employeeFamily;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeFamily='" + employeeFamily + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", unit=" + unit.getUnitName() +
                '}';
    }
}
