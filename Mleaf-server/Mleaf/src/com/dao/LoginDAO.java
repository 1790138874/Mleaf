package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DBManager;

/**
 * ��½������
 * @author MYQ
 *
 */

public class LoginDAO {

    public Boolean login(String username, String password) {

        // ��ȡSQL��ѯ���
        String logSql = "select * from table_password where username='" + username
                + "' and password ='" + password + "'";

        // ��ȡDB����
        DBManager sql = DBManager.createInstance();
        sql.connectDB();

        // ����DB����
        try {
            ResultSet rs = sql.executeQuery(logSql);
            if (rs.next()) {
                	sql.closeDB();
                    return true;  	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.closeDB();
        return false;
    }

 
}