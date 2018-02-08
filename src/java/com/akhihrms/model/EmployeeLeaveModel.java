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
public class EmployeeLeaveModel {

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    private int leaveId;
    private String leaveType;
    private String leaveDesc;

    private String leaveEmpId;
    private String leaveFrom;
    private String leaveTo;
    private String leavePurpose;
    private int leaveRequestId;
    private String requestStatus;

    public boolean insertLeaveRequest(EmployeeInfoModel empModel) {
        boolean flag = false;
        int count = 0;
        String query = "INSERT INTO `hrms`.`leave_request` (`emp_id`, `leave_type`, `from`, `to`, `leave_purpose`) VALUES ('" + empModel.getEmpIdForLeaveRequest() + "', '" + empModel.getLeaveType() + "', '" + empModel.getLeaveFrom() + "', '" + empModel.getLeaveTo() + "', '" + empModel.getLeavePurpose() + "')";
        System.out.println(query);
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

            count = stmt.executeUpdate(query);
            if(count>0){
                flag = true;
            }

        } catch (Exception e) {
            System.out.println(e);
            flag = false;
        }
        return flag;
    }

    public List<EmployeeLeaveModel> getLeaveTypeList() {
        List<EmployeeLeaveModel> leaveTypeList = new ArrayList<>();
        String query = "select * from leave_type";
        System.out.println(query);
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                EmployeeLeaveModel obj = new EmployeeLeaveModel();
                obj.setLeaveId(rs.getInt("leave_type_id"));
                obj.setLeaveType(rs.getString("leave_type_name"));
                obj.setLeaveDesc(rs.getString("leave_rule"));
                leaveTypeList.add(obj);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return leaveTypeList;
    }

    public boolean insertLeaveType(EmployeeLeaveModel empModel) {
        boolean flag = false;
        int count = 0;
        String query = "insert into leave_type (leave_type_name, leave_rule) values('" + empModel.getLeaveType() + "','" + empModel.getLeaveDesc() + "')";
        System.out.println(query);
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

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

    public boolean deletetLeaveType(int id) {
        boolean flag = false;
        int count = 0;
        String query = "delete from leave_type where leave_type_id = '" + id + "'";
        System.out.println(query);
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

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

    public List<EmployeeLeaveModel> getLeaveRule(int id) {
        List<EmployeeLeaveModel> leaveTypeList = new ArrayList<>();
        String query = "select * from leave_type where leave_type_id='" + id + "'";
        System.out.println(query);
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                EmployeeLeaveModel obj = new EmployeeLeaveModel();
                obj.setLeaveId(rs.getInt("leave_type_id"));
                obj.setLeaveType(rs.getString("leave_type_name"));
                obj.setLeaveDesc(rs.getString("leave_rule"));
                leaveTypeList.add(obj);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return leaveTypeList;
    }
    
     public List<EmployeeLeaveModel> getLeavePurposeForChairman(int id) {
        List<EmployeeLeaveModel> leaveTypeList = new ArrayList<>();
        String query = "select * from leave_request where id='" + id + "'";
        System.out.println(query);
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                EmployeeLeaveModel obj = new EmployeeLeaveModel();
                obj.setLeaveEmpId(rs.getString("emp_id"));
                obj.setLeavePurpose(rs.getString("leave_purpose"));
                leaveTypeList.add(obj);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return leaveTypeList;
    }

    public List<EmployeeLeaveModel> getLeaveRequests() {
        List<EmployeeLeaveModel> leaveRequestList = new ArrayList<>();
        String query = "select * from leave_request";
        System.out.println(query);
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                EmployeeLeaveModel obj = new EmployeeLeaveModel();
                obj.setLeaveRequestId(rs.getInt("id"));
                obj.setLeaveEmpId(rs.getString("emp_id"));
                obj.setLeaveType(rs.getString("leave_type"));
                obj.setLeaveFrom(rs.getString("from"));
                obj.setLeaveTo(rs.getString("to"));
                obj.setLeavePurpose(rs.getString("leave_purpose"));
                obj.setRequestStatus(rs.getString("status"));
                leaveRequestList.add(obj);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return leaveRequestList;
    }
    
     public List<EmployeeLeaveModel> getLeaveRequestByEmpId(String userName) {
        List<EmployeeLeaveModel> leaveRequestList = new ArrayList<>();
        String query = "select * from leave_request where emp_id ="
                + "(select id from users where userName='"+userName+"') and status='approved'";
        System.out.println(query);
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                EmployeeLeaveModel obj = new EmployeeLeaveModel();
                obj.setLeaveRequestId(rs.getInt("id"));
                obj.setLeaveEmpId(rs.getString("emp_id"));
                obj.setLeaveType(rs.getString("leave_type"));
                obj.setLeaveFrom(rs.getString("from"));
                obj.setLeaveTo(rs.getString("to"));
                obj.setLeavePurpose(rs.getString("leave_purpose"));
                obj.setRequestStatus(rs.getString("status"));
                leaveRequestList.add(obj);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return leaveRequestList;
    }
    
     public List<EmployeeLeaveModel> getApprovedOnly() {
        List<EmployeeLeaveModel> leaveRequestList = new ArrayList<>();
        String query = "select * from leave_request where status='approved'";
        System.out.println(query);
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                EmployeeLeaveModel obj = new EmployeeLeaveModel();
                obj.setLeaveRequestId(rs.getInt("id"));
                obj.setLeaveEmpId(rs.getString("emp_id"));
                obj.setLeaveType(rs.getString("leave_type"));
                obj.setLeaveFrom(rs.getString("from"));
                obj.setLeaveTo(rs.getString("to"));
                obj.setLeavePurpose(rs.getString("leave_purpose"));
                obj.setRequestStatus(rs.getString("status"));
                leaveRequestList.add(obj);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return leaveRequestList;
    }
     public List<EmployeeLeaveModel> getDeclinedOnly() {
        List<EmployeeLeaveModel> leaveRequestList = new ArrayList<>();
        String query = "select * from leave_request where status='declined'";
        System.out.println(query);
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                EmployeeLeaveModel obj = new EmployeeLeaveModel();
                obj.setLeaveRequestId(rs.getInt("id"));
                obj.setLeaveEmpId(rs.getString("emp_id"));
                obj.setLeaveType(rs.getString("leave_type"));
                obj.setLeaveFrom(rs.getString("from"));
                obj.setLeaveTo(rs.getString("to"));
                obj.setLeavePurpose(rs.getString("leave_purpose"));
                obj.setRequestStatus(rs.getString("status"));
                leaveRequestList.add(obj);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return leaveRequestList;
    }
     public boolean approveLeaveRequest(int id) {
        boolean flag = false;
        int count = 0;
        String query = "update leave_request set status='approved' where id = '" + id + "'";
        System.out.println(query);
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

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
     
     public boolean declineLeaveRequest(int id) {
        boolean flag = false;
        int count = 0;
        String query = "update leave_request set status='declined' where id = '" + id + "'";
        System.out.println(query);
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

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
    
     
     
     public List<EmployeeLeaveModel> getAllLeaveTypesAndRole() {
        List<EmployeeLeaveModel> leaveTypeList = new ArrayList<>();
        String query = "select * from leave_type";
        System.out.println(query);
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                EmployeeLeaveModel obj = new EmployeeLeaveModel();
                obj.setLeaveId(rs.getInt("leave_type_id"));
                obj.setLeaveType(rs.getString("leave_type_name"));
                obj.setLeaveDesc(rs.getString("leave_rule"));
                leaveTypeList.add(obj);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return leaveTypeList;
    }
    

    /**
     * @return the leaveId
     */
    public int getLeaveId() {
        return leaveId;
    }

    /**
     * @param leaveId the leaveId to set
     */
    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
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
     * @return the leaveDesc
     */
    public String getLeaveDesc() {
        return leaveDesc;
    }

    /**
     * @param leaveDesc the leaveDesc to set
     */
    public void setLeaveDesc(String leaveDesc) {
        this.leaveDesc = leaveDesc;
    }

    /**
     * @return the leaveEmpId
     */
    public String getLeaveEmpId() {
        return leaveEmpId;
    }

    /**
     * @param leaveEmpId the leaveEmpId to set
     */
    public void setLeaveEmpId(String leaveEmpId) {
        this.leaveEmpId = leaveEmpId;
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
     * @return the leaveRequestId
     */
    public int getLeaveRequestId() {
        return leaveRequestId;
    }

    /**
     * @param leaveRequestId the leaveRequestId to set
     */
    public void setLeaveRequestId(int leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }

    /**
     * @return the requestStatus
     */
    public String getRequestStatus() {
        return requestStatus;
    }

    /**
     * @param requestStatus the requestStatus to set
     */
    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

}
