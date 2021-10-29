package model.dao;

import model.entity.ConnectionManager;
import model.entity.Employee;

import java.sql.*;

public class EmployeeDao {
    private UnitDao unitDao = new UnitDao();

    public void saveEmployee(Employee employee) {
        Connection connection = ConnectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO `employee`(`name`, `family`," +
                    " `code`, `birth`, `unit_id`) VALUES (?,?,?,?,?)");
            statement.setString(1, employee.getEmployeeName());
            statement.setString(2, employee.getEmployeeFamily());
            statement.setString(3, employee.getEmployeeCode());
            statement.setDate(4, java.sql.Date.valueOf(employee.getBirthDate()));
            statement.setInt(5, employee.getUnit().getId_unit());
            int i = statement.executeUpdate();
            System.out.println(i + " employee inserted");
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public Employee findByName(String name) {
        Connection connection = ConnectionManager.getConnection();
        Employee employee = new Employee();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT `name`, `family`, `code`, `birth`," +
                    " `unit_id` FROM `employee` As e WHERE e.name = ?");
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.setEmployeeName(resultSet.getString(1));
                employee.setEmployeeFamily(resultSet.getString(2));
                employee.setEmployeeCode(resultSet.getString(3));
                employee.setBirthDate(resultSet.getString(4));
                int unitId = resultSet.getInt(5);
                String unitName = unitDao.findById(unitId);
                employee.setUnit(unitDao.findByName(unitName));
            }
            return employee;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
