package com.warehouse.model.user;

import com.warehouse.model.wh.Warehouse;

import java.util.List;

public class RegularUser extends KnownUser {

    public RegularUser() {
    }

    public RegularUser(UserRole role) {
        super(role);
    }

    public RegularUser(Long id, UserRole role) {
        super(id, role);
    }

    public RegularUser(UserRole role, String name, String surname, String email, String yearOfBirth,
                       String placeOfBirth, String currentPosition, String addressOfLiving, List<Warehouse> warehouseList) {
        super(role, name, surname, email, yearOfBirth, placeOfBirth, currentPosition, addressOfLiving, warehouseList);
    }

    @Override
    public UserRole getRole() {
        return super.getRole();
    }

    @Override
    public void setRole(UserRole role) {
        role = UserRole.REGULAR_USER;
    }

    @Override
    public String toString() {
        return "RegularUser{" +
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
