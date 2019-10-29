/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import com.mysql.jdbc.Connection;
import dao.design.ICustomerDAO;
import dao.ds.DBAccess;
import dao.objects.Address;
import dao.objects.City;
import dao.objects.Country;
import dao.objects.Customer;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AULAFISI
 */
public class CustomerDAO implements ICustomerDAO {
    
    private DBAccess db;

    public CustomerDAO() {
        db = new DBAccess();
    }
    
    @Override
    public List<Customer> getCustomerPerCountry(int country_id) {
        Connection cn = db.getConnection();
        
        List<Customer> list = new ArrayList<>();
        String sql = "{CALL sp_get_customer_per_country(?)}";
        
        
        try{
            CallableStatement callableStatement = cn.prepareCall(sql);
            callableStatement.setInt(1, country_id);
            ResultSet resultSet = callableStatement.executeQuery();
            
            while(resultSet.next()){
                
                Country cy = new Country();
                cy.setCountry(resultSet.getString("country"));
                
                City ct = new City();
                ct.setCity(resultSet.getString("city"));
                ct.setCountry(cy);
                
                Address a = new Address();
                a.setAddress(resultSet.getString("address"));
                a.setDistrict(resultSet.getString("district"));
                a.setPostal_code(resultSet.getString("postal_code"));
                a.setPhone(resultSet.getString("phone"));
                a.setCity(ct);
                
                Customer c = new Customer();
                c.setCustomer_id(resultSet.getInt("customer_id"));
                c.setFirst_name(resultSet.getString("first_name"));
                c.setLast_name(resultSet.getString("last_name"));
                c.setEmail(resultSet.getString("email"));
                c.setAddress(a);
                
                list.add(c);
            }
        }catch(SQLException e){
           e.printStackTrace();
        }
                
        return list;
        
        
    }
    
    
    
}
