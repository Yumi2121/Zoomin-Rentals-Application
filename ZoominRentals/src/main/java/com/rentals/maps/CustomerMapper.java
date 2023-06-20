package com.rentals.maps;
import org.springframework.jdbc.core.RowMapper;

import com.rentals.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer c = new Customer();
		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));
    	c.setEmail(rs.getString("email"));
    	c.setMobile(rs.getString("mobile"));
    	c.setPassword(rs.getString("password"));
    	c.setLicenseno(rs.getInt("licenseno"));
    	return c;
    	
	}

}
