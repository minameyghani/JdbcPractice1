package view;

import model.dao.EmployeeDao;
import model.dao.UnitDao;
import model.entity.Employee;
import model.entity.Unit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;
        while (repeat) {
            System.out.println("welcome to project.what would you like to do?");
            System.out.println("1-add employee");
            System.out.println("2-add unit");
            System.out.println("3-search a unit based name");
            System.out.println("4-search an employee based name");
            System.out.println("5-search an employee based family");
            System.out.println("6-search an employee based code");
            System.out.println("7-update employee name");
            System.out.println("8-update employee family");
            System.out.println("9-delete employee");
            System.out.println("10-employees number in a unit");
            System.out.println("11-exit");
            int answer = scanner.nextInt();
            switch (answer) {
                case 1:
                    registerEmployee();
                    break;
                case 2:
                    registerUnit();
                    break;
                case 3:
                    findUnitByName();
                    break;
                case 4:
                    findEmployeeByName();
                    break;
                case 5:
                    findEmployeeByFamily();
                    break;
                case 6:
                    findEmployeeByCode();
                    break;
                case 7:
                    updateName();
                    break;
                case 8:
                    updateFamily();
                    break;
                case 9:
                    deleteEmployee();
                    break;
                case 10:
                    countPerUnit();
                    break;
                case 11:
                    repeat = false;
            }

        }

    }

    public static void registerEmployee() {
        EmployeeDao dao = new EmployeeDao();
        Scanner scanner = new Scanner(System.in);
        System.out.println("how many employees would you like to add?");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            Employee employee = create();
            dao.saveEmployee(employee);
        }
        System.out.println();
        System.out.println("------------------");
    }

    public static Employee create() {
        Employee employee = new Employee();
        UnitDao dao = new UnitDao();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = scanner.next();
        employee.setEmployeeName(name);
        System.out.println("Enter family:");
        String family = scanner.next();
        employee.setEmployeeFamily(family);
        System.out.println("Enter code:");
        String code = scanner.next();
        employee.setEmployeeCode(code);
        System.out.println("Enter birth date:(format:yyyy-mm-dd)");
        String birth = scanner.next();
        employee.setBirthDate(birth);
        System.out.println("choose your unit id: ");
        dao.findAll();
        int id = scanner.nextInt();
        employee.setUnit(dao.findUnitById(id));
        return employee;
    }

    public static void registerUnit() {
        UnitDao dao = new UnitDao();
        Scanner scanner = new Scanner(System.in);
        System.out.println("how many units would you like to add?");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            Unit unit = createUnit();
            dao.saveUnit(unit);
        }
        System.out.println();
        System.out.println("------------------");
    }

    public static Unit createUnit() {
        Unit unit = new Unit();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = scanner.next();
        unit.setUnitName(name);
        System.out.println("Enter phone:");
        String phone = scanner.next();
        unit.setPhoneNumber(phone);
        return unit;
    }

    public static void findUnitByName() {
        Scanner scanner = new Scanner(System.in);
        UnitDao unitDao = new UnitDao();
        System.out.println("Enter unit name:");
        String next = scanner.next();
        Unit unit = unitDao.findByName(next);
        if (unit != null) {
            System.out.println(unit.toString());
            System.out.println();
            System.out.println("------------------");
        } else {
            System.out.println("unit not found");
            System.out.println();
        }
    }

    public static void findEmployeeByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee name:");
        String name = scanner.next();
        EmployeeDao dao = new EmployeeDao();
        Employee em = dao.findByName(name);
        if (em != null) {
            System.out.println(em.toString());
        } else {
            System.out.println("employee not found");
        }
    }

    public static void findEmployeeByFamily() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee family:");
        String family = scanner.next();
        EmployeeDao dao = new EmployeeDao();
        Employee em = dao.findByFamily(family);
        if (em != null) {
            System.out.println(em.toString());
        } else {
            System.out.println("employee not found");
        }
    }

    public static void findEmployeeByCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee code:");
        String code = scanner.next();
        EmployeeDao dao = new EmployeeDao();
        Employee em = dao.findByCode(code);
        if (em != null) {
            System.out.println(em.toString());
        } else {
            System.out.println("employee not found");
        }
    }

    public static void updateName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your code for changing name:");
        String code = scanner.next();
        EmployeeDao dao = new EmployeeDao();
        Employee em = dao.findByCode(code);
        if (em != null) {
            System.out.println(em.toString());
            dao.updateName(em.getEmployeeName(), newName());
        } else {
            System.out.println("employee not found");
        }
    }

    public static void updateFamily() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your code for changing family:");
        String code = scanner.next();
        EmployeeDao dao = new EmployeeDao();
        Employee em = dao.findByCode(code);
        if (em != null) {
            System.out.println(em.toString());
            dao.updateFamily(em.getEmployeeFamily(), newName());
        } else {
            System.out.println("employee not found");
        }
    }

    public static String newName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter new one:");
        return scanner.next();
    }

    public static void deleteEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your code for delete Employee:");
        String code = scanner.next();
        EmployeeDao dao = new EmployeeDao();
        Employee em = dao.findByCode(code);
        if (em != null) {
            System.out.println(em.toString());
            dao.deleteByCode(code);
        } else {
            System.out.println("employee not found");
        }
    }

    public static void countPerUnit() {
        UnitDao unitDao = new UnitDao();
        unitDao.findAll();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter unit id:");
        int id = scanner.nextInt();
        String name = unitDao.findById(id);
        if (!name.isEmpty() || name != null) {
            EmployeeDao employeeDao = new EmployeeDao();
            employeeDao.countPerUnit(name);
        } else {
            System.out.println("unit not found");
        }
    }

}

