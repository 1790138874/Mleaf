package com.dao;


import com.db.DBManager;

/**
 * ע�������
 * @author MYQ
 *
 */

public class RegisterDAO {

    public Boolean register(String username, String password) {
    	
        // ��ȡSQL�������
        String regSql = "replace into table_password values('"+ username+ "','"+ password+ "') ";

        // ��ȡDB����
        DBManager sql = DBManager.createInstance();
        sql.connectDB();

        int ret = sql.executeUpdate(regSql);
        if (ret != 0) {
            sql.closeDB();
            return true;
        }
        sql.closeDB();
        
        return false;
    }
}
