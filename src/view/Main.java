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
        String s  = employeeDao.findByFamily("zamani").getEmployeeFamily();
        employeeDao.updateFamily(s,"samiei");


    }
}
