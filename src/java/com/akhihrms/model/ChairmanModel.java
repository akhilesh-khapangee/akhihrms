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
public class ChairmanModel {

    static Connection con;
    static Statement stmt;
    static ResultSet rs;

    private String projectName;
    private String projectTask;
    private int projectDetailId;
    private String projectStartDate;
    private String projectEndDate;
    private int taskId;
    private String taskEmpId;
    private String assignedEmployee;
    private int projectTaskDetailId;
    private String taskDesc;
    private String updatedTaskDesc;
    private String hiddenProjectTaskId;

    
    public List<ChairmanModel> getAllTaskDetail() {
        List<ChairmanModel> myProjectTaskList = new ArrayList<>();

        String query = "select * from project_task_details;";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                ChairmanModel chairModel = new ChairmanModel();
                chairModel.setProjectDetailId(rs.getInt("id"));
                chairModel.setProjectName(rs.getString("project_name"));
                chairModel.setProjectTask(rs.getString("task_name"));
                chairModel.setAssignedEmployee(rs.getString("employee"));
                chairModel.setTaskDesc(rs.getString("task_desc"));
                myProjectTaskList.add(chairModel);

                System.out.println("DB==============");
                System.out.println(rs.getInt("id") + "DB===");
                System.out.println(rs.getString("project_name") + "DB===");
                System.out.println(rs.getString("task_name") + "DB===");
                System.out.println(rs.getString("employee") + "DB==");
                System.out.println(rs.getString("task_desc") + "DB==");

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return myProjectTaskList;
    }
    
    public boolean updateTaskProgress(int hiddenProjectTaskId, String updatedTaskDesc) {
       boolean flag = false;
       System.out.println(hiddenProjectTaskId+"<========>"+updatedTaskDesc);
       int count = 0;
        String query = "update project_task_details set task_desc='"+updatedTaskDesc+"' where id =" + hiddenProjectTaskId + " ";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

           count = stmt.executeUpdate(query);
           if(count>0){
               flag = true;
           }

        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }

    public List<ChairmanModel> getClickedTaskDesc(ChairmanModel chairModel, int id) {
      
        List<ChairmanModel> tstUpdateList = new ArrayList<>();
        
        String query = "select id, task_desc from project_task_details where id =" + id + " ";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                chairModel.setProjectDetailId(rs.getInt("id"));
                chairModel.setTaskDesc(rs.getString("task_desc"));
                tstUpdateList.add(chairModel);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return tstUpdateList;
    }

    public List<ChairmanModel> getMyTaskList(String userName) {
        List<ChairmanModel> myProjectTaskList = new ArrayList<>();

        String query = "select * from project_task_details where employee = (select concat(f_name,\" \",l_name) as full_name from employees where emp_id = (select id from users where userName = '" + userName + "'));\n"
                + "		";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                ChairmanModel chairModel = new ChairmanModel();
                chairModel.setProjectDetailId(rs.getInt("id"));
                chairModel.setProjectName(rs.getString("project_name"));
                chairModel.setProjectTask(rs.getString("task_name"));
                chairModel.setAssignedEmployee(rs.getString("employee"));
                chairModel.setTaskDesc(rs.getString("task_desc"));
                myProjectTaskList.add(chairModel);

                System.out.println("DB==============");
                System.out.println(rs.getInt("id") + "DB===");
                System.out.println(rs.getString("project_name") + "DB===");
                System.out.println(rs.getString("task_name") + "DB===");
                System.out.println(rs.getString("employee") + "DB==");
                System.out.println(rs.getString("task_desc") + "DB==");

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return myProjectTaskList;
    }

    public List<ChairmanModel> getProjectTaskDetailList() {
        List<ChairmanModel> projectTaskList = new ArrayList<>();

        String query = "select * from project_task_details;";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                ChairmanModel chairModel = new ChairmanModel();
                chairModel.setProjectName(rs.getString("project_name"));
                chairModel.setProjectTask(rs.getString("task_name"));
                chairModel.setAssignedEmployee(rs.getString("employee"));
                projectTaskList.add(chairModel);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return projectTaskList;
    }

    public boolean insertTaskAssignment(ChairmanModel chairModel) {
        int count = 0;
        boolean flag = false;
        String query = "insert into project_task_details (project_name, task_name,employee)"
                + " values('" + chairModel.getProjectName() + "','" + chairModel.getProjectTask() + "'"
                + ",'" + chairModel.getAssignedEmployee() + "')";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();
            if (chairModel.getAssignedEmployee() != null) {
                count = stmt.executeUpdate(query);
            }

            if (count > 0) {
                flag = true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }

    public List<ChairmanModel> getTaskList() {
        List<ChairmanModel> taskList = new ArrayList<>();

        String query = "select * from task";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                ChairmanModel chairModel = new ChairmanModel();
                chairModel.setTaskId(rs.getInt("task_id"));
                chairModel.setProjectTask(rs.getString("task_name"));
                taskList.add(chairModel);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return taskList;
    }

    public boolean createProjectTask(ChairmanModel chairModel) {
        int count = 0;
        boolean flag = false;
        String query = "insert into task (task_name) values('" + chairModel.getProjectTask() + "')";
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

    public List<ChairmanModel> getProjectList() {
        List<ChairmanModel> projectList = new ArrayList<>();

        String query = "select * from project_details;";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                ChairmanModel chairModel = new ChairmanModel();
                chairModel.setProjectDetailId(rs.getInt("project_detail_id"));
                chairModel.setProjectName(rs.getString("project_name"));
                chairModel.setProjectStartDate(rs.getString("start_date"));
                chairModel.setProjectEndDate(rs.getString("end_date"));
                projectList.add(chairModel);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return projectList;
    }

    public boolean createProject(ChairmanModel chairModel) {
        boolean flag = false;
        int s = 0;
        String query = "insert into project_details (project_name,start_date,end_date) values('" + chairModel.getProjectName() + "',"
                + "'" + chairModel.getProjectStartDate() + "','" + chairModel.getProjectEndDate() + "')";
        try {
            con = ConnectionDAO.getConnection();
            stmt = con.createStatement();

            if (chairModel.getProjectName() != null) {
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

    /**
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * @return the projectTask
     */
    public String getProjectTask() {
        return projectTask;
    }

    /**
     * @param projectTask the projectTask to set
     */
    public void setProjectTask(String projectTask) {
        this.projectTask = projectTask;
    }

    /**
     * @return the projectDetailId
     */
    public int getProjectDetailId() {
        return projectDetailId;
    }

    /**
     * @param projectDetailId the projectDetailId to set
     */
    public void setProjectDetailId(int projectDetailId) {
        this.projectDetailId = projectDetailId;
    }

    /**
     * @return the projectStartDate
     */
    public String getProjectStartDate() {
        return projectStartDate;
    }

    /**
     * @param projectStartDate the projectStartDate to set
     */
    public void setProjectStartDate(String projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    /**
     * @return the projectEndDate
     */
    public String getProjectEndDate() {
        return projectEndDate;
    }

    /**
     * @param projectEndDate the projectEndDate to set
     */
    public void setProjectEndDate(String projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    /**
     * @return the taskId
     */
    public int getTaskId() {
        return taskId;
    }

    /**
     * @param taskId the taskId to set
     */
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    /**
     * @return the taskEmpId
     */
    public String getTaskEmpId() {
        return taskEmpId;
    }

    /**
     * @param taskEmpId the taskEmpId to set
     */
    public void setTaskEmpId(String taskEmpId) {
        this.taskEmpId = taskEmpId;
    }

    /**
     * @return the assignedEmployee
     */
    public String getAssignedEmployee() {
        return assignedEmployee;
    }

    /**
     * @param assignedEmployee the assignedEmployee to set
     */
    public void setAssignedEmployee(String assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    /**
     * @return the projectTaskDetailId
     */
    public int getProjectTaskDetailId() {
        return projectTaskDetailId;
    }

    /**
     * @param projectTaskDetailId the projectTaskDetailId to set
     */
    public void setProjectTaskDetailId(int projectTaskDetailId) {
        this.projectTaskDetailId = projectTaskDetailId;
    }

    /**
     * @return the taskDesc
     */
    public String getTaskDesc() {
        return taskDesc;
    }

    /**
     * @param taskDesc the taskDesc to set
     */
    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    /**
     * @return the updatedTaskDesc
     */
    public String getUpdatedTaskDesc() {
        return updatedTaskDesc;
    }

    /**
     * @param updatedTaskDesc the updatedTaskDesc to set
     */
    public void setUpdatedTaskDesc(String updatedTaskDesc) {
        this.updatedTaskDesc = updatedTaskDesc;
    }

    /**
     * @return the hiddenProjectTaskId
     */
    public String getHiddenProjectTaskId() {
        return hiddenProjectTaskId;
    }

    /**
     * @param hiddenProjectTaskId the hiddenProjectTaskId to set
     */
    public void setHiddenProjectTaskId(String hiddenProjectTaskId) {
        this.hiddenProjectTaskId = hiddenProjectTaskId;
    }

}
