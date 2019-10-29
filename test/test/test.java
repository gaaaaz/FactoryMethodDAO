/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.DAOFactory;
import dao.design.ICountryDAO;
import dao.design.ICustomerDAO;
import dao.ds.DBAccess;
import dao.objects.Country;
import dao.objects.Customer;
import java.lang.reflect.Array;
import java.util.List;

/**
 *
 * @author AULAFISI
 */
public class test {
    public static void main(String[] args) {
        
        /*DBAccess db = new DBAccess();
        db.getConnection();
        
        ICountryDAO countryDAO = DAOFactory.getInstance().getCountryDAO();
        List<Country> list = countryDAO.getCountries();
        
        for (Country c: list) {
            System.out.println(c.getCountry_id() + " " + c.getCountry());
        }
        
        ICustomerDAO customerDAO = DAOFactory.getInstance().getCustomerDAO();
        List<Customer> l = customerDAO.getCustomerPerCountry(2);
        
        for (Customer c: l) {
            System.out.println(c.getFirst_name() + " " + c.getAddress().getPhone() + " " + c.getAddress().getCity().getCountryObj().getCountry());
        }*/
        
    }
}
