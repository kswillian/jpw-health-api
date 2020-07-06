package com.jpwhealth.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
public class CovidGeneralData implements Serializable {

    private static final long serialVersionUID = -1905907502453138175L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("CountryCode")
    private String countryCode;

    @JsonProperty("Province")
    private String province;

    @JsonProperty("City")
    private String city;

    @JsonProperty("CityCode")
    private String cityCode;

    @Column(precision = 10, scale = 4)
    @Type(type = "big_decimal")
    @JsonProperty("Lat")
    private BigDecimal latitude;

    @Column(precision = 10, scale = 4)
    @Type(type = "big_decimal")
    @JsonProperty("Lon")
    private BigDecimal longitude;

    @JsonProperty("Confirmed")
    private BigInteger confirmed;

    @JsonProperty("Deaths")
    private BigInteger deaths;

    @JsonProperty("Recovered")
    private BigInteger recovered;

    @JsonProperty("Active")
    private BigInteger active;

    @JsonProperty("Date")
    private LocalDateTime date;

    public CovidGeneralData() {
    }

    public CovidGeneralData(Long id, String country, String countryCode, String province, String city, String cityCode, BigDecimal latitude, BigDecimal longitude, BigInteger confirmed, BigInteger deaths, BigInteger recovered, BigInteger active, LocalDateTime date) {
        this.id = id;
        this.country = country;
        this.countryCode = countryCode;
        this.province = province;
        this.city = city;
        this.cityCode = cityCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
        this.active = active;
        this.date = date;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigInteger getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(BigInteger confirmed) {
        this.confirmed = confirmed;
    }

    public BigInteger getDeaths() {
        return deaths;
    }

    public void setDeaths(BigInteger deaths) {
        this.deaths = deaths;
    }

    public BigInteger getRecovered() {
        return recovered;
    }

    public void setRecovered(BigInteger recovered) {
        this.recovered = recovered;
    }

    public BigInteger getActive() {
        return active;
    }

    public void setActive(BigInteger active) {
        this.active = active;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CovidGeneralData{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", confirmed=" + confirmed +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                ", active=" + active +
                ", date=" + date +
                '}';
    }
}
