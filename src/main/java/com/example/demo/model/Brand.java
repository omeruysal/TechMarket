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
public class Brand {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="brand_name")
	private String brandName;
	
	@OneToMany(mappedBy="brand")
	private List<Product> products = new ArrayList<>();
	
	private Boolean publish;

	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Brand(Integer id, String brandName, List<Product> products, Boolean publish) {
		super();
		this.id = id;
		this.brandName = brandName;
		this.products = products;
		this.publish = publish;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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
		result = prime * result + ((brandName == null) ? 0 : brandName.hashCode());
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
		Brand other = (Brand) obj;
		if (brandName == null) {
			if (other.brandName != null)
				return false;
		} else if (!brandName.equals(other.brandName))
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
		return "Brand [id=" + id + ", brandName=" + brandName + ", products=" + products + ", publish=" + publish + "]";
	}

	
	
	
	
	
	
}
