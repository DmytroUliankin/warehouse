package com.warehouse.model.warehouse;

import com.warehouse.model.user.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Warehouse {

    @NonNull
    private Long id;

    private String number;

    private String name;

    @NonNull
    private WarehouseRegion region;

    private String address;

    private String capacity;

    private User user;

}
