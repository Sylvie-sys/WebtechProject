package com.social.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inpatient_table")
public class Inpatient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String firstname;
    private String lastname;
    private String guardianname;

    public Inpatient() {
    }

    public Inpatient(Integer id, String firstname, String lastname, String guardianname, String guardianphone, String socialcase, String province, String district) {
        Id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.guardianname = guardianname;
        this.guardianphone = guardianphone;
        this.socialcase = socialcase;
        this.province = province;
        this.district = district;
    }

    private String guardianphone;
    private String socialcase;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGuardianname() {
        return guardianname;
    }

    public void setGuardianname(String guardianname) {
        this.guardianname = guardianname;
    }

    public String getGuardianphone() {
        return guardianphone;
    }

    public void setGuardianphone(String guardianphone) {
        this.guardianphone = guardianphone;
    }

    public String getSocialcase() {
        return socialcase;
    }

    public void setSocialcase(String socialcase) {
        this.socialcase = socialcase;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    private String province;
    private String district;

    @Override
    public String toString() {
        return "Inpatient{" +
                "Id=" + Id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", guardianname='" + guardianname + '\'' +
                ", guardianphone='" + guardianphone + '\'' +
                ", socialcase='" + socialcase + '\'' +
                ", province='" + province + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
