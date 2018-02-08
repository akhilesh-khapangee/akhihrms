package com.akhihrms.model;

import com.akhihrms.dao.ConnectionDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * This model class contains the properties for the filed on the login.jsp page.
 *
 * @author Akhilesh
 *
 */
public class LoginModel {

    static Connection con = null;
    static ResultSet rs = null;
    static Statement stmt = null;

    private String enterPassword;
    private String confirmPassoword;

    private String userEmpId;
    private String empUserName;
    private String empPassword;
    private String userType;
    private String role;

    /* This is the attribute name (path) of username field in login.jsp page */
    private String userName;

    /* This is the attribute name (path) of Password field in login.jsp page */
    private String password;

    /* Getters and setters for the private fields. */
    public String checkUserRole(String userName) {
        String currentRole = null;
        System.out.println("hello checkUserRole ");

        String query = "select role from users where userName='" + userName + "'";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                currentRole = rs.getString("role");
            }

            System.out.println(query);
        } catch (Exception e) {
            System.out.println(e);
        } 
        return currentRole;

    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the empUserName
     */
    public String getEmpUserName() {
        return empUserName;
    }

    /**
     * @param empUserName the empUserName to set
     */
    public void setEmpUserName(String empUserName) {
        this.empUserName = empUserName;
    }

    /**
     * @return the empPassword
     */
    public String getEmpPassword() {
        return empPassword;
    }

    /**
     * @param empPassword the empPassword to set
     */
    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    /**
     * @return the userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @return the userEmpId
     */
    public String getUserEmpId() {
        return userEmpId;
    }

    /**
     * @param userEmpId the userEmpId to set
     */
    public void setUserEmpId(String userEmpId) {
        this.userEmpId = userEmpId;
    }

//    public static LoginModel findByUsername(String userName) {
//        LoginModel user = new LoginModel();
//        String query = "select * from users where userName='" + userName + "'";
//        try {
//            con = ConnectionDAO.getConnection();
//            stmt = con.createStatement();
//            rs = stmt.executeQuery(query);
//
//            while (rs.next()) {
//                user.setUserName(rs.getString("userName"));
//                user.setRole(rs.getString("role"));
//                
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            try {
//                stmt.close();
//                rs.close();
//                con.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            return user;
//        }
//
//    }
    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the enterPassword
     */
    public String getEnterPassword() {
        return enterPassword;
    }

    /**
     * @param enterPassword the enterPassword to set
     */
    public void setEnterPassword(String enterPassword) {
        this.enterPassword = enterPassword;
    }

    /**
     * @return the confirmPassoword
     */
    public String getConfirmPassoword() {
        return confirmPassoword;
    }

    /**
     * @param confirmPassoword the confirmPassoword to set
     */
    public void setConfirmPassoword(String confirmPassoword) {
        this.confirmPassoword = confirmPassoword;
    }
}
