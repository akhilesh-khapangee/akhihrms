package com.akhihrms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhihrms.dao.LoginDAO;
import com.akhihrms.model.LoginModel;
/**
 * Implementation of LoginService
 * @author Akhilesh
 *
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginDAO loginDAO;
	
	public String validate(LoginModel loginModel) {
		return loginDAO.validate(loginModel);
	}

}
