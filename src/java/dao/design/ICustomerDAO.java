/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design;

import dao.objects.Customer;
import java.util.List;

/**
 *
 * @author AULAFISI
 */
public interface ICustomerDAO {
    
    public abstract List<Customer> getCustomerPerCountry(int country_id);
    
}
