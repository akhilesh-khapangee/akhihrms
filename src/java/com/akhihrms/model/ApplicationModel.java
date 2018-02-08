package com.akhihrms.model;

/**
 * This model class is used mainly to send the data into a single object which
 * contains all the details that is needed to be displayed on the jsp pages.
 *
 * @author Akhilesh
 *
 */
public class ApplicationModel {

    private LoginModel loginModel;
    private EmployeeInfoModel addEmpModel;

    public LoginModel getLoginModel() {
        return loginModel;
    }

    public void setLoginModel(LoginModel loginModel) {
        this.loginModel = loginModel;
    }

    public EmployeeInfoModel getAddEmployeeModel() {
        return addEmpModel;
    }
    public void setAddEmployeeModel(EmployeeInfoModel addEmpModel) {
        this.addEmpModel = addEmpModel;
    }
}
