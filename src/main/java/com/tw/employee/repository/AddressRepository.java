package com.tw.employee.repository;

import com.tw.employee.model.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepository extends BaseRepository {

    public int create(final Address address) {
        final String sql = "insert into address (street, city, state, zip_code) values (?, ?, ?, ?)";
        return create(new String[]{address.getStreet(), address.getCity(), address.getState(), address.getZipCode()}, sql);
    }


}
