package model.dao;

import model.entity.ConnectionManager;
import model.entity.Unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UnitDao {
    public void saveUnit(Unit unit){
        Connection connection = ConnectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO `unit`(`name`, `phone`) VALUES " +
                    "(?,?)");
            statement.setString(1,unit.getUnitName());
            statement.setString(2,unit.getPhoneNumber());
            int i = statement.executeUpdate();
            System.out.println(i+" unit inserted");
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
