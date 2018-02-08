package com.akhihrms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.akhihrms.model.LoginModel;

/**
 * Implementation of the LoginDao Interface
 *
 * @author Akhilesh
 */
@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {

    String role;

    @Override
    public String validate(LoginModel loginModel) {
        System.out.println(loginModel.getUserName()+"=================");

        String SQL = "SELECT * FROM users WHERE userName = '" + loginModel.getUserName() + "' and binary password = '" + loginModel.getPassword() + "';";
        System.out.println("SQL : " + SQL);
        Statement stmt;
        try {
            stmt = ConnectionDAO.getStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (null != rs && rs.next()) {
                if (rs.getString("role").equals("Admin")) {
                    role = "admin";
                } else if (rs.getString("role").equals("Employee")) {
                    role = "employee";
                } else if (rs.getString("role").equals("Chairman")) {
                    role = "chairman";
                }

            } else {
                role = "login";
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception : " + e.getMessage());
            role = "login";
        }
        return role;
    }
}
