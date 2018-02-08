package com.akhihrms.model;

import com.akhihrms.dao.ConnectionDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author samsung
 */
public class DeleteEmployeeModel {

    static Connection con;
    static Statement stmt;
    static ResultSet rs;

    public boolean deleteEmployeeProfile(String empId) {
        System.out.println(empId + "butterflay");
        int s = 0;
        boolean flag = false;
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            s = stmt.executeUpdate("delete from employees where emp_id='" + empId + "'");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            System.out.println("got 4");
            if (s > 0) {
                flag = true;
            } else {
                flag = false;
            }
            return flag;
        }
    }
}
