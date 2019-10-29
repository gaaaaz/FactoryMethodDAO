/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import com.mysql.jdbc.Connection;
import dao.design.ICountryDAO;
import dao.ds.DBAccess;
import dao.objects.Country;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AULAFISI
 */
public class CountryDAO implements ICountryDAO{
    
    private DBAccess db;

    public CountryDAO() {
        db = new DBAccess();
    }
    
    @Override
    public List<Country> getCountries() {
        
        Connection cn = db.getConnection();
        
        List<Country> list = new ArrayList<>();
        String sql = "{CALL sp_get_countries()}";
        
        try{
            CallableStatement callableStatement = cn.prepareCall(sql);
            ResultSet resultSet = callableStatement.executeQuery();
            
            while(resultSet.next()){
                Country c = new Country();
                
                c.setCountry_id(resultSet.getInt("country_id"));
                c.setCountry(resultSet.getString("country"));
                
                list.add(c);
            }
        }catch(SQLException e){
           e.printStackTrace();
        }
                
        return list;
        
    }
    
}
