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
public class EmployeeInfoModel {

    private String empId;
    private String firstName;
    private String lastName;
    private String gender;
    private String department;
    private String designation;
    private String joinDate;
    private String jobStatus;
    private String qualification;
    private String cellNo;
    private String residenceContact;
    private String emailId;
    private String address;

    private String empIdForLeaveRequest;
    private String leaveType;
    private String leaveFrom;
    private String leaveTo;
    private String leavePurpose;

    private String departmentName;
    private String designationName;
    private int departmentId;
    private int designationId;

    static Connection con;
    static Statement stmt;
    static ResultSet rs;

    public boolean deleteDepartment(int id) {
        int count = 0;
        boolean flag = false;
        String query = "delete from department where department_id ='"+id+"'";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

            count = stmt.executeUpdate(query);

            if (count > 0) {
                flag = true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }
    public boolean deleteDesignation(int id) {
        int count = 0;
        boolean flag = false;
        String query = "delete from designation where designation_id ='"+id+"'";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

            count = stmt.executeUpdate(query);

            if (count > 0) {
                flag = true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }

    public List<EmployeeInfoModel> getDepartmentList() {
        List<EmployeeInfoModel> departList = new ArrayList<>();

        String query = "select * from department;";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                EmployeeInfoModel empModel = new EmployeeInfoModel();
                empModel.setDepartmentId(rs.getInt("department_id"));
                empModel.setDepartmentName(rs.getString("department_name"));
                departList.add(empModel);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return departList;
    }

    public List<EmployeeInfoModel> getDesignationList() {
        List<EmployeeInfoModel> desigList = new ArrayList<>();

        String query = "select * from designation;";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                EmployeeInfoModel empModel = new EmployeeInfoModel();
                empModel.setDesignationId(rs.getInt("designation_id"));
                empModel.setDesignationName(rs.getString("designation_name"));
                desigList.add(empModel);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return desigList;
    }

    public boolean createDesignation(EmployeeInfoModel empModel) {
        int count = 0;
        boolean flag = false;
        String query = "insert into designation (designation_name) values('" + empModel.getDesignationName() + "')";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

            count = stmt.executeUpdate(query);

            if (count > 0) {
                flag = true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }

    public boolean createDepartmentName(EmployeeInfoModel empModel) {
        int count = 0;
        boolean flag = false;
        String query = "insert into department (department_name) values('" + empModel.getDepartmentName() + "')";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

            count = stmt.executeUpdate(query);

            if (count > 0) {
                flag = true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }

    /**
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the joinDate
     */
    public String getJoinDate() {
        return joinDate;
    }

    /**
     * @param joinDate the joinDate to set
     */
    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * @return the jobStatus
     */
    public String getJobStatus() {
        return jobStatus;
    }

    /**
     * @param jobStatus the jobStatus to set
     */
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    /**
     * @return the qualification
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * @param qualification the qualification to set
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * @return the cellNo
     */
    public String getCellNo() {
        return cellNo;
    }

    /**
     * @param cellNo the cellNo to set
     */
    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    /**
     * @return the residenceContact
     */
    public String getResidenceContact() {
        return residenceContact;
    }

    /**
     * @param residenceContact the residenceContact to set
     */
    public void setResidenceContact(String residenceContact) {
        this.residenceContact = residenceContact;
    }

    /**
     * @return the emailId
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * @param emailId the emailId to set
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return the leaveType
     */
    public String getLeaveType() {
        return leaveType;
    }

    /**
     * @param leaveType the leaveType to set
     */
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    /**
     * @return the leaveFrom
     */
    public String getLeaveFrom() {
        return leaveFrom;
    }

    /**
     * @param leaveFrom the leaveFrom to set
     */
    public void setLeaveFrom(String leaveFrom) {
        this.leaveFrom = leaveFrom;
    }

    /**
     * @return the leaveTo
     */
    public String getLeaveTo() {
        return leaveTo;
    }

    /**
     * @param leaveTo the leaveTo to set
     */
    public void setLeaveTo(String leaveTo) {
        this.leaveTo = leaveTo;
    }

    /**
     * @return the leavePurpose
     */
    public String getLeavePurpose() {
        return leavePurpose;
    }

    /**
     * @param leavePurpose the leavePurpose to set
     */
    public void setLeavePurpose(String leavePurpose) {
        this.leavePurpose = leavePurpose;
    }

    /**
     * @return the empIdForLeaveRequest
     */
    public String getEmpIdForLeaveRequest() {
        return empIdForLeaveRequest;
    }

    /**
     * @param empIdForLeaveRequest the empIdForLeaveRequest to set
     */
    public void setEmpIdForLeaveRequest(String empIdForLeaveRequest) {
        this.empIdForLeaveRequest = empIdForLeaveRequest;
    }

    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName the departmentName to set
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * @return the designationId
     */
    public int getDesignationId() {
        return designationId;
    }

    /**
     * @param designationId the designationId to set
     */
    public void setDesignationId(int designationId) {
        this.designationId = designationId;
    }

    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * @return the designationName
     */
    public String getDesignationName() {
        return designationName;
    }

    /**
     * @param designationName the designationName to set
     */
    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    /**
     * @return the departmentId
     */
    public int getDepartmentId() {
        return departmentId;
    }

    /**
     * @return the leaveType
     */
}
