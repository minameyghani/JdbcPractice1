package view;

import model.dao.EmployeeDao;
import model.dao.UnitDao;
import model.entity.Employee;
import model.entity.Unit;

public class Main {
    public static void main(String[] args) {
        /*UnitDao unitDao = new UnitDao();
        String u = unitDao.findById(1);
        System.out.println(u);*/
        EmployeeDao employeeDao = new EmployeeDao();
        Employee s = employeeDao.findByName("sara");
        System.out.println(s.toString());


    }
}
