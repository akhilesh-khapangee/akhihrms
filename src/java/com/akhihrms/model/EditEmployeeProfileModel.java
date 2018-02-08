package com.akhihrms.model;

import com.akhihrms.dao.ConnectionDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samsung
 */
public class EditEmployeeProfileModel {

    static Connection con;
    static Statement stmt;
    static ResultSet rs;

    public List<EmployeeInfoModel> getEmployeeProfile(String empId) {
        List<EmployeeInfoModel> empList = new ArrayList<>();

        String query = "select * from employees where emp_id='" + empId + "'";
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

    public boolean getEditEmployeeProfile(EmployeeInfoModel empModel, String empId) {
        boolean flag = false;
        int s = 0;
        System.out.println(empModel.getCellNo()+"____________");
        String query = "update employees set emp_id='" + empModel.getEmpId() + "',f_name='" + empModel.getFirstName()+ "',"
                + "l_name='" + empModel.getLastName()+ "',gender='" + empModel.getGender()+ "',department='" + empModel.getDepartment()+ "'"
                + ",designation='" + empModel.getDesignation()+ "',join_date='" + empModel.getJoinDate()+ "',job_status='" + empModel.getJobStatus()+ "'"
                + ",qualification='" + empModel.getQualification()+ "',cell_no='" + empModel.getCellNo()+ "'"
                + ",residence_contact='" + empModel.getResidenceContact()+ "',email_id='" + empModel.getEmailId()+ "'"
                + ",address='" + empModel.getAddress()+ "'"
                + " where emp_id='" + empId + "'";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            s = stmt.executeUpdate(query);
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
