package com.warehouse.model.user;

import com.warehouse.model.warehouse.Warehouse;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @lombok.NonNull
    private Long id;

    @lombok.NonNull
    private UserRole role;

    private String name;

    private String surname;

    private String email;

    private String yearOfBirth;

    private String placeOfBirth;

    private String currentPosition;

    private String addressOfLiving;

    private List<Warehouse> warehouseList;

}
