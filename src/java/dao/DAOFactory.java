/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.component.AddressDAO;
import dao.component.CityDAO;
import dao.component.CountryDAO;
import dao.component.CustomerDAO;
import dao.design.IAddressDAO;
import dao.design.ICityDAO;
import dao.design.ICountryDAO;
import dao.design.ICustomerDAO;

/**
 *
 * @author AULAFISI
 */
public class DAOFactory {
    private static DAOFactory daoFac;
    
    static{
        daoFac = new DAOFactory();
    }
    
    public static DAOFactory getInstance(){
        return daoFac;
    }
    
    public ICountryDAO getCountryDAO(){
        return new CountryDAO();
    }
    
    public ICityDAO getCityDAO(){
        return new CityDAO();
    }
    
    public ICustomerDAO getCustomerDAO(){
        return new CustomerDAO();
    }
    
    public IAddressDAO getAddressDAO(){
        return new AddressDAO();
    }
}
