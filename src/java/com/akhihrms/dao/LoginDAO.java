package com.akhihrms.dao;

import com.akhihrms.model.LoginModel;
/**
 * LoginDAO interface
 * @author Akhilesh
 *
 */
public interface LoginDAO {

	public String validate(LoginModel loginModel);
}