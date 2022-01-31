package com.warehouse.model.user;

import com.warehouse.model.wh.Warehouse;

import java.util.List;

public abstract class User {

    private Long id;

    private UserRole role;

    private String name;

    private String surname;

    private String email;

    private String yearOfBirth;

    private String placeOfBirth;

    private String currentPosition;

    private String addressOfLiving;

    private List<Warehouse> warehouseList;

    public User() {
    }

    public User(UserRole role) {
        this.role = role;
    }

    public User(Long id, UserRole role) {
        this.id = id;
        this.role = role;
    }

    public User(UserRole role, String name, String surname, String email, String yearOfBirth,
                String placeOfBirth, String currentPosition, String addressOfLiving, List<Warehouse> warehouseList) {
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.yearOfBirth = yearOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.currentPosition = currentPosition;
        this.addressOfLiving = addressOfLiving;
        this.warehouseList = warehouseList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getAddressOfLiving() {
        return addressOfLiving;
    }

    public void setAddressOfLiving(String addressOfLiving) {
        this.addressOfLiving = addressOfLiving;
    }

    public List<Warehouse> getWarehouseList() {
        return warehouseList;
    }

    public void setWarehouseList(List<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", currentPosition='" + currentPosition + '\'' +
                ", addressOfLiving='" + addressOfLiving + '\'' +
                ", warehouseList=" + warehouseList +
                '}';
    }

}
