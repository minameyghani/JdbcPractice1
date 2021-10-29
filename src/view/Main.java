package view;

import model.dao.UnitDao;
import model.entity.Unit;

public class Main {
    public static void main(String[] args) {
        Unit unit = new Unit();
        unit.setUnitName("asad");
        unit.setPhoneNumber("123");
        UnitDao unitDao = new UnitDao();
        unitDao.saveUnit(unit);

    }
}
