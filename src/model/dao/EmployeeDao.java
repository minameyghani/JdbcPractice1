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
            statement.setString(1, name);
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
            connection.close();
            return employee;


        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public Integer findIdByName(String name) {
        Connection connection = ConnectionManager.getConnection();
        String name1 = findByName(name).getEmployeeName();
        Employee employee = new Employee();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT `id`" +
                    " FROM `employee` As e WHERE e.name = ?");
            statement.setString(1, name1);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.setId_employee(resultSet.getInt(1));
            }
            connection.close();
            return employee.getId_employee();


        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public Integer findIdByFamily(String family) {
        Connection connection = ConnectionManager.getConnection();
        String family1 = findByFamily(family).getEmployeeFamily();
        Employee employee = new Employee();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT `id`" +
                    " FROM `employee` As e WHERE e.family = ?");
            statement.setString(1, family1);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.setId_employee(resultSet.getInt(1));
            }
            connection.close();
            return employee.getId_employee();


        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public Employee findByFamily(String family) {
        Connection connection = ConnectionManager.getConnection();
        Employee employee = new Employee();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT `name`, `family`, `code`, `birth`," +
                    " `unit_id` FROM `employee` As e WHERE e.family = ?");
            statement.setString(1, family);
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
            connection.close();
            return employee;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public Employee findByCode(String code) {
        Connection connection = ConnectionManager.getConnection();
        Employee employee = new Employee();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT `name`, `family`, `code`, `birth`," +
                    " `unit_id` FROM `employee` As e WHERE e.code = ?");
            statement.setString(1, code);
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
            connection.close();
            return employee;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void updateName(String name1, String name2) {
        Connection connection = ConnectionManager.getConnection();
        try {
            Integer id = findIdByName(name1);

            PreparedStatement statement = connection.prepareStatement("UPDATE `employee` As e SET e.name = ? " +
                    "WHERE e.id = ?");
            statement.setString(1, name2);
            statement.setInt(2,id);
            statement.executeUpdate();
            System.out.println("updated employee name");
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void updateFamily(String family1, String family2) {
        Connection connection = ConnectionManager.getConnection();
        try {
            Integer id = findIdByFamily(family1);

            PreparedStatement statement = connection.prepareStatement("UPDATE `employee` As e SET e.family = ? " +
                    "WHERE e.id = ?");
            statement.setString(1, family2);
            statement.setInt(2,id);
            statement.executeUpdate();
            System.out.println("updated employee family");
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
