package com.akhihrms.dao;

import com.akhihrms.model.EmployeeInfoModel;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.stereotype.Repository;

/**
 *
 * @author samsung
 */
@Repository("EmployeeInfoDAO")
public class EmployeeInfoDAOImpl implements EmployeeInfoDAO {

    @Override
    public boolean insertEmployee(EmployeeInfoModel addEmpModel) {
        boolean flag = false;
        System.out.println("Hello");
        String query = "insert into employees values('"+addEmpModel.getEmpId()+"','"+addEmpModel.getFirstName()+"',"
                + "'"+addEmpModel.getLastName()+"','"+addEmpModel.getGender()+"','"+addEmpModel.getDepartment()+"',"
                + "'"+addEmpModel.getDesignation()+"','"+addEmpModel.getJoinDate()+"','"+addEmpModel.getJobStatus()+"','"+addEmpModel.getQualification()+"',"
                + "'"+addEmpModel.getCellNo()+"','"+addEmpModel.getResidenceContact()+"','"+addEmpModel.getEmailId()+"',"
                + "'"+addEmpModel.getAddress()+"')";
        Statement stmt;
        System.out.println(query);
        try {
            stmt = ConnectionDAO.getStatement();
            stmt.executeUpdate(query);
            flag= true;
        } catch (Exception e) {
            System.out.println(e);

        }
        return flag;
    }
    
    
    
}
