/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.objects;

/**
 *
 * @author AULAFISI
 */
public class City {
    
    private int city_id;
    private String city;
    private Country country;

    public City() {
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountryObj() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    
    
}
