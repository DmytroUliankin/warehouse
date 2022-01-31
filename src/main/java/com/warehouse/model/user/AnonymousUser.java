package com.warehouse.model.user;

import com.warehouse.model.wh.Warehouse;

import java.util.List;

public class AnonymousUser extends User {

    public AnonymousUser() {
    }

    public AnonymousUser(UserRole role) {
        super(role);
    }

    public AnonymousUser(Long id, UserRole role) {
        super(id, role);
    }

    public AnonymousUser(UserRole role, String name, String surname, String email, String yearOfBirth,
                         String placeOfBirth, String currentPosition, String addressOfLiving, List<Warehouse> warehouseList) {
        super(role, name, surname, email, yearOfBirth, placeOfBirth, currentPosition, addressOfLiving, warehouseList);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        name = "";
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public void setSurname(String surname) {
        surname = "";
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        email = "";
    }

    @Override
    public String getYearOfBirth() {
        return super.getYearOfBirth();
    }

    @Override
    public void setYearOfBirth(String yearOfBirth) {
        yearOfBirth = "";
    }

    @Override
    public String getPlaceOfBirth() {
        return super.getPlaceOfBirth();
    }

    @Override
    public void setPlaceOfBirth(String placeOfBirth) {
        placeOfBirth = "";
    }

    @Override
    public String getCurrentPosition() {
        return super.getCurrentPosition();
    }

    @Override
    public void setCurrentPosition(String currentPosition) {
        currentPosition = "";
    }

    @Override
    public String getAddressOfLiving() {
        return super.getAddressOfLiving();
    }

    @Override
    public void setAddressOfLiving(String addressOfLiving) {
        addressOfLiving = "";
    }

    @Override
    public List<Warehouse> getWarehouseList() {
        return super.getWarehouseList();
    }

    @Override
    public void setWarehouseList(List<Warehouse> warehouseList) {
        warehouseList = List.of();
    }

    @Override
    public UserRole getRole() {
        return super.getRole();
    }

    @Override
    public void setRole(UserRole role) {
        role = UserRole.ANONYMOUS_USER;
    }

    @Override
    public String toString() {
        return "AnonymousUser{" +
                ", role=" + getRole() +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", yearOfBirth='" + getYearOfBirth() + '\'' +
                ", placeOfBirth='" + getPlaceOfBirth() + '\'' +
                ", currentPosition='" + getCurrentPosition() + '\'' +
                ", addressOfLiving='" + getAddressOfLiving() + '\'' +
                ", warehouseList=" + getWarehouseList() +
                '}';
    }

}
