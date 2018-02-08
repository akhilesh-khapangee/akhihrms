/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akhihrms.service;

import com.akhihrms.dao.EmployeeInfoDAO;
import com.akhihrms.model.EmployeeInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author samsung
 */
@Service("EmployeeInfoService")
public class EmployeeInfoServiceImpl implements EmployeeInfoService {
    @Autowired
     EmployeeInfoDAO addEmpDAO;
     public boolean insertEmployee(EmployeeInfoModel addEmpModel) {
		return addEmpDAO.insertEmployee(addEmpModel);
	}

}
