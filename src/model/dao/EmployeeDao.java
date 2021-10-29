package model.dao;

import model.entity.ConnectionManager;
import model.entity.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao {
    public void saveEmployee(Employee employee){
        Connection connection = ConnectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO `employee`(`name`, `family`," +
                    " `code`, `birth`, `unit_id`) VALUES (?,?,?,?,?)");
            statement.setString(1,employee.getEmployeeName());
            statement.setString(2,employee.getEmployeeFamily());
            statement.setString(3,employee.getEmployeeCode());
            statement.setDate(4, java.sql.Date.valueOf(employee.getBirthDate()));
            statement.setInt(5,employee.getUnit().getId_unit());
            int i = statement.executeUpdate();
            System.out.println(i+" employee inserted");
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
