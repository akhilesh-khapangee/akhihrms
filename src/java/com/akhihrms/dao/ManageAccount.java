package com.akhihrms.dao;

import com.akhihrms.model.LoginModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samsung
 */
public class ManageAccount {

    static Connection con;
    static Statement stmt;
    static ResultSet rs;

    public boolean createEmployeeAccount(LoginModel loginModel) {
        boolean flag = false;
        int count = 0;
        String query = "INSERT INTO `hrms`.`users` (`userName`, `password`, `role`, `id`) VALUES ('" + loginModel.getEmpUserName() + "', '" + loginModel.getEmpPassword() + "', '" + loginModel.getUserType() + "', '" + loginModel.getUserEmpId() + "');";
        try {
            stmt = ConnectionDAO.getStatement();
            count = stmt.executeUpdate(query);
            if (count > 0) {
                flag = true;
            }

        } catch (Exception e) {
            System.out.println(e);
            flag = false;

        }
        return flag;
    }

    public List<LoginModel> getUserAccounts() {
        List<LoginModel> empList = new ArrayList<>();

        String query = "select * from users";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                LoginModel user = new LoginModel();
                user.setEmpUserName(rs.getString("userName"));
                user.setUserType(rs.getString("role"));
                user.setUserEmpId(rs.getString("id"));

                empList.add(user);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return empList;
    }

    public boolean deleteUserAccount(String userName) {

        int s = 0;
        boolean flag = false;
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            s = stmt.executeUpdate("delete from users where userName='" + userName + "'");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (s > 0) {
                flag = true;
            } else {
                flag = false;
            }
            return flag;
        }
    }

    public boolean changePassword(LoginModel loginModel, String userName) {
        boolean flag = false;
        int s = 0;
        String query = "update users set password='" + loginModel.getEnterPassword() + "' where userName='" + userName + "'";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            if (userName != null) {
                s = stmt.executeUpdate(query);
            }
            if (s > 0) {
                flag = true;
            }

        } catch (Exception e) {
            System.out.println(e);
            flag = false;
        }
        return flag;
    }
}
