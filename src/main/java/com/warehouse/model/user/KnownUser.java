package com.warehouse.model.user;

import com.warehouse.model.wh.Warehouse;

import java.util.List;

public abstract class KnownUser extends User {

    public KnownUser() {
    }

    public KnownUser(UserRole role) {
        super(role);
    }

    public KnownUser(Long id, UserRole role) {
        super(id, role);
    }

    public KnownUser(UserRole role, String name, String surname, String email, String yearOfBirth,
                     String placeOfBirth, String currentPosition, String addressOfLiving, List<Warehouse> warehouseList) {
        super(role, name, surname, email, yearOfBirth, placeOfBirth, currentPosition, addressOfLiving, warehouseList);
    }

    @Override
    public String toString() {
        return "KnownUser{" +
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
