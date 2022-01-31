package com.warehouse.model.user;

import com.warehouse.model.wh.Warehouse;

import java.util.List;

public class AdminUser extends KnownUser {

    public AdminUser() {
    }

    public AdminUser(UserRole role) {
        super(role);
    }

    public AdminUser(Long id, UserRole role) {
        super(id, role);
    }

    public AdminUser(UserRole role, String name, String surname, String email, String yearOfBirth,
                     String placeOfBirth, String currentPosition, String addressOfLiving, List<Warehouse> warehouseList) {
        super(role, name, surname, email, yearOfBirth, placeOfBirth, currentPosition, addressOfLiving, warehouseList);
    }

    @Override
    public UserRole getRole() {
        return super.getRole();
    }

    @Override
    public void setRole(UserRole role) {
        role = UserRole.ADMIN;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
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
