package com.nwt.webproject.model.entity.request;

import lombok.Data;

import com.nwt.webproject.common.Key;
import com.nwt.webproject.common.Props;
import com.nwt.webproject.model.entity.Users;
import com.nwt.webproject.model.entity.embedded.Address;
import com.nwt.webproject.model.entity.enums.Role;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * User Request Object
 *
 * @author: Prabakar Singaram
 * @created: 3/11/2013 12:54 AM
 * @company: NewWave Technologies Inc
 */
@XStreamAlias(Key.user)
public @Data class UserRO {
    public String username;
    public String password;
    public String confirm;
    public String email;
    public String mobile;
    public @XStreamAlias(Key.role) Role role;
    public String companyName;
    public String streetAddress;
    public String city;
    public String state;
    public String country;
    public String postalCode;


    public Users user(Props props) {
        Users user = new Users();
        user.setUserName(username);
        user.setPassWord(password);
        user.setEmail(email);
        user.setMobile(mobile);

        if(role != null)
            user.setRole(role);
        else
            user.setRole(Role.USER);

        Address address = new Address();
        address.setStreetAddress(streetAddress);
        address.setCity(city);
        address.setState(state);
        address.setPostalCode(postalCode);
        if (country == null || country.trim().equalsIgnoreCase("")) {
            address.setCountry(props.fUserCountry);
        } else {
            address.setCountry(country);
        }

        user.setAddress(address);
        return user;
    }


    @Override public String toString() {
        return "UserRO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirm='" + confirm + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", role=" + role +
                ", companyName='" + companyName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
