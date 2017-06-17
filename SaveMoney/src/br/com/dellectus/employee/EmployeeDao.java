/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dellectus.employee;

import java.util.List;



/**
 *
 * @author Vikram
 */
public interface EmployeeDao {
    
    public void saveEmployee (EmployeeDetails employee);
    public List<EmployeeDetails> showAllEmployees();
    public void updateEmployee (int id, String ename, String enumber);
    public void deleteEmployee (EmployeeDetails employee);
    
    
}
