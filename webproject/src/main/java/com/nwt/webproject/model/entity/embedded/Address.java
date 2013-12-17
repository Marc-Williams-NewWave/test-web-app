package com.nwt.webproject.model.entity.embedded;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

import com.nwt.webproject.common.Key;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Address embeddable entity
 *
 * @author: Prabakar Singaram
 * @created: 4/5/2013 9:04 AM
 * @company: NewWave Technologies Inc
 */
@Embeddable
@XStreamAlias(Key.address)
@XmlRootElement(name = Key.address)
public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String postalCode;


    @XmlElement @NotNull @NotBlank
    public String getStreetAddress() {
        return streetAddress;
    }


    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }


    @XmlElement @NotNull @NotBlank
    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    @XmlElement @NotNull @NotBlank
    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }


    @XmlElement @NotNull @NotBlank
    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }


    @XmlElement @NotNull @NotBlank
    public String getPostalCode() {
        return postalCode;
    }


    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    @Override public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
