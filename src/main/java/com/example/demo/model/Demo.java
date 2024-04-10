package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Id;

@Entity
@Table(name="Demo")
public class Demo {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
   @Column(name="name")
    private String name;
   @Column(name="description")
    private String description;
   @Column(name="price")
    private int price;
   @Column(nullable = true, length=64)
   private String photos;
   private int search;

    public Demo(){
    }
    
    public Demo(int id, String name, String description, int price){
        super();
        this.id=id;
        this.name=name;
        this.description=description;
        this.price=price;
    }
    @Override
    public String toString() {
    	return "Id=" + id + ", Name=" + name + ", Description=" + description + ", Price=" + price;
    }
    
    @Transient
    public String getPhotosImagePath() {
    	if(photos==null) return null;
    	return "/product-photos/" + id + "/" + photos;
    }
    /**
     * @return id return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return long return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }
    
	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public void display() {
		// TODO Auto-generated method stub
		
	}

	public int getSearch(int id) {
		return search;
	}

	public void setSearch(int search) {
		this.search = search;
	}

	public void addAttribute(int id) {
		// TODO Auto-generated method stub
		
	}
	public void addAttribute(List<Demo> listProduct) {
		// TODO Auto-generated method stub
	}

}