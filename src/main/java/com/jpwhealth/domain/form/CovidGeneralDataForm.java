package com.jpwhealth.domain.form;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

public class CovidGeneralDataForm {

    @NotNull
    private String country;
    private String countryCode;
    private String province;
    private String city;
    private String cityCode;
    private BigDecimal latitude;
    private BigDecimal longitude;

    @NotNull
    private BigInteger confirmed;

    @NotNull
    private BigInteger deaths;

    @NotNull
    private BigInteger recovered;

    @NotNull
    private BigInteger active;

    @NotNull
    private LocalDateTime date;

    public CovidGeneralDataForm() {
    }

    public CovidGeneralDataForm(@NotNull String country, String countryCode, String province, String city, String cityCode, BigDecimal latitude, BigDecimal longitude, @NotNull BigInteger confirmed, @NotNull BigInteger deaths, @NotNull BigInteger recovered, @NotNull BigInteger active, @NotNull LocalDateTime date) {
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

    public String getCountry() {
        return country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getCityCode() {
        return cityCode;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public BigInteger getConfirmed() {
        return confirmed;
    }

    public BigInteger getDeaths() {
        return deaths;
    }

    public BigInteger getRecovered() {
        return recovered;
    }

    public BigInteger getActive() {
        return active;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "CovidGeneralDataForm{" +
                "country='" + country + '\'' +
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
