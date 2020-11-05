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

@Repository
public class BrandRepositoryJdbc {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Brand> rowMapper = new RowMapper<Brand>() {
		
		@Override
		public Brand mapRow(ResultSet rs, int rowNum) throws SQLException {
			Brand brand = new Brand();
			brand.setId(rs.getInt("id"));
			brand.setBrandName(rs.getString("brand_name"));
			brand.setProducts(null);
			brand.setPublish(rs.getBoolean("publish"));
			return brand;
		}
	};
	
	public List<Brand> findAll(){
		System.out.println("jdbc kullanildi");
		return jdbcTemplate.query("select * from brand", rowMapper);
		
	}
	public Brand findById(Integer id){
		System.out.println("jdbc kullanildi");
		return DataAccessUtils.singleResult(jdbcTemplate.query("select * from brand where id = ?", rowMapper,id));
		
	}
	
	public Brand findByName(String name){
		System.out.println("jdbc kullanildi");
		return DataAccessUtils.singleResult(jdbcTemplate.query("select * from brand where brand_name like ?", rowMapper,"%",name,"%"));
		
	}
	
}
