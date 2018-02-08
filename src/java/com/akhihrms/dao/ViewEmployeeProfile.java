package com.akhihrms.dao;

import com.akhihrms.model.EmployeeInfoModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samsung
 */
public class ViewEmployeeProfile {

    static Connection con;
    static Statement stmt;
    static ResultSet rs;

    public static List<EmployeeInfoModel> getEmployeeList() {
        List<EmployeeInfoModel> empList = new ArrayList<>();

        String query = "select * from employees";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                EmployeeInfoModel emp = new EmployeeInfoModel();
                emp.setEmpId(rs.getString("emp_id"));
                emp.setFirstName(rs.getString("f_name"));
                emp.setLastName(rs.getString("l_name"));
                emp.setDepartment(rs.getString("department"));
                emp.setGender(rs.getString("gender"));
                empList.add(emp);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return empList;
    }

    public List<EmployeeInfoModel> getEmployeeFullProfile(String empId) {
        List<EmployeeInfoModel> empList = new ArrayList<>();

        String query = "select * from employees where emp_id = '" + empId + "'";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                EmployeeInfoModel emp = new EmployeeInfoModel();
                emp.setEmpId(rs.getString("emp_id"));
                emp.setFirstName(rs.getString("f_name"));
                emp.setLastName(rs.getString("l_name"));
                emp.setGender(rs.getString("gender"));
                emp.setDepartment(rs.getString("department"));
                emp.setDesignation(rs.getString("designation"));
                emp.setJoinDate(rs.getString("join_date"));
                emp.setJobStatus(rs.getString("job_status"));
                emp.setQualification(rs.getString("qualification"));
                emp.setCellNo(rs.getString("cell_no"));
                emp.setResidenceContact(rs.getString("residence_contact"));
                emp.setEmailId(rs.getString("email_id"));
                emp.setAddress(rs.getString("address"));
                empList.add(emp);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return empList;
    }

    public List<EmployeeInfoModel> checkEmployeeProfileByChairman(int id) {
        List<EmployeeInfoModel> empList = new ArrayList<>();

        String query = "select * from employees "
                + "where emp_id =(select emp_id from leave_request where id= '" + id + "')";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                EmployeeInfoModel emp = new EmployeeInfoModel();
                emp.setEmpId(rs.getString("emp_id"));
                emp.setFirstName(rs.getString("f_name"));
                emp.setLastName(rs.getString("l_name"));
                emp.setGender(rs.getString("gender"));
                emp.setDepartment(rs.getString("department"));
                emp.setDesignation(rs.getString("designation"));
                emp.setJoinDate(rs.getString("join_date"));
                emp.setJobStatus(rs.getString("job_status"));
                emp.setQualification(rs.getString("qualification"));
                emp.setCellNo(rs.getString("cell_no"));
                emp.setResidenceContact(rs.getString("residence_contact"));
                emp.setEmailId(rs.getString("email_id"));
                emp.setAddress(rs.getString("address"));
                empList.add(emp);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return empList;
    }

    public List<EmployeeInfoModel> getEmployeeList(String userName) {
        List<EmployeeInfoModel> empList = new ArrayList<>();

        String query = "select * from employees where emp_id =(select id from users where userName = '" + userName + "')";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            if (userName != null) {
                rs = stmt.executeQuery(query);
            }

            while (rs.next()) {
                EmployeeInfoModel emp = new EmployeeInfoModel();
                emp.setEmpId(rs.getString("emp_id"));
                emp.setFirstName(rs.getString("f_name"));
                emp.setLastName(rs.getString("l_name"));
                emp.setGender(rs.getString("gender"));
                emp.setDepartment(rs.getString("department"));
                emp.setDesignation(rs.getString("designation"));
                emp.setJoinDate(rs.getString("join_date"));
                emp.setJobStatus(rs.getString("job_status"));
                emp.setQualification(rs.getString("qualification"));
                emp.setCellNo(rs.getString("cell_no"));
                emp.setResidenceContact(rs.getString("residence_contact"));
                emp.setEmailId(rs.getString("email_id"));
                emp.setAddress(rs.getString("address"));
                empList.add(emp);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return empList;
    }
}
