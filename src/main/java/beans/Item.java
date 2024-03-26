package beans;

import java.io.Serializable;

/**
 * 商品情報
 */
public class Item implements Serializable{
	
	private int id;				// id
	private String name;		// 名前
	private String image;	// 画像パス(表紙の画像)
	private String description;	// 説明文
	private int price;			// 値段
	private int inventory;		// 在庫
	
	private int image_id;	// 画像ID
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public int getImage_id() {
		return image_id;
	}
	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}
	
	
	
	
		
}
