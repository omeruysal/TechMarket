package com.example.demo.jdbcrepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Brand;
import com.example.demo.model.User;

@Repository
public class UserRepositoryJdbc {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<User> rowMapper = new RowMapper<User>() {
		
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setAddress(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setId(rs.getInt("id"));
			user.setMail(rs.getString("mail"));
			user.setPassword(rs.getString("password"));
			user.setProducts(null);
			return user;
		}
	};
	
	public List<User> findAll(){
		System.out.println("jdbc kullanildi");
		return jdbcTemplate.query("select * from user", rowMapper);
	}
	public User findById(Integer id){
		System.out.println("jdbc kullanildi");
		return DataAccessUtils.singleResult(jdbcTemplate.query("select * from user where id = ?", rowMapper,id));
		
	}
	
	public User findByName(String name){
		System.out.println("jdbc kullanildi");
		return DataAccessUtils.singleResult(jdbcTemplate.query("select * from user where first_name like ?", rowMapper,"%",name,"%"));
		
	}

}
