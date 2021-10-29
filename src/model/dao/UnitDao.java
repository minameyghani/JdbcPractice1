package model.dao;

import model.entity.ConnectionManager;
import model.entity.Unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public Unit findByName(String unitName){
        Connection connection = ConnectionManager.getConnection();
        Unit u = new Unit();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `unit` AS u WHERE u.name = ?");
            statement.setString(1,unitName);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                u.setId_unit(result.getInt(1));
                u.setUnitName(result.getString(2));
                u.setPhoneNumber(result.getString(3));
            }
            return u;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
    public String findById(Integer unitId){
        Connection connection = ConnectionManager.getConnection();
        Unit u = new Unit();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT u.name FROM `unit` AS u WHERE u.id = ?");
            statement.setInt(1,unitId);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                u.setUnitName(result.getString(1));

            }
            return u.getUnitName();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
