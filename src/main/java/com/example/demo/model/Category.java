package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="category_name")
	private String categoryName;
	
	@OneToMany(mappedBy="category")
	private List<Product> products = new ArrayList<>();
	
	private Boolean publish;

	public Category() {
		
	}
	
	
	
	public Category(Integer id, String categoryName, List<Product> products, Boolean publish) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.products = products;
		this.publish = publish;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Boolean getPublish() {
		return publish;
	}

	public void setPublish(Boolean publish) {
		this.publish = publish;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		result = prime * result + ((publish == null) ? 0 : publish.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (publish == null) {
			if (other.publish != null)
				return false;
		} else if (!publish.equals(other.publish))
			return false;
		return true;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

}
