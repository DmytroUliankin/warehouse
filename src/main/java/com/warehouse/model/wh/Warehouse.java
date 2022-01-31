package com.warehouse.model.wh;

import com.warehouse.model.user.User;

public class Warehouse {

    private Long id;

    private String number;

    private String name;

    private WarehouseRegion region;

    private String address;

    private String capacity;

    private User user;

    public Warehouse() {
    }

    public Warehouse(WarehouseRegion region) {
        this.region = region;
    }

    public Warehouse(String number, String name, WarehouseRegion region, String address, String capacity, User user) {
        this.number = number;
        this.name = name;
        this.region = region;
        this.address = address;
        this.capacity = capacity;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WarehouseRegion getRegion() {
        return region;
    }

    public void setRegion(WarehouseRegion region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", region=" + region +
                ", address='" + address + '\'' +
                ", capacity='" + capacity + '\'' +
                ", user=" + user +
                '}';
    }

}
