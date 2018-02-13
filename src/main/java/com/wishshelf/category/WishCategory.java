package com.wishshelf.category;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="wishcategory")

public class WishCategory {
	
	
	private Object _id;
	private String description;
	@NotNull
	@Size(min=3,max=20)
	private String wishcategory;
	private String wishsubcategory;
	
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Object get_id() {
		return _id;
	}


	public void set_id(Object _id) {
		this._id = _id;
	}


	private int wishcategoryid;
	

	public int getWishcategoryid() {
		return wishcategoryid;
	}


	public void setWishcategoryid(int wishcategoryid) {
		this.wishcategoryid = wishcategoryid;
	}


	public String getWishcategory() {
		return wishcategory;
	}


	public void setWishcategory(String wishcategory) {
		this.wishcategory = wishcategory;
	}



	

	protected WishCategory(){
		
	}
	public WishCategory(int id, String wishcategory, String subCategory) {
		super();
		this.wishcategoryid = id;
		this.wishcategory = wishcategory;
		this.wishsubcategory = subCategory;
	}

	
	/*public WishCategory(WishCategotyBuilder categoryBuilder){
		this.wishcategoryId=categoryBuilder.bwishcategoryId;
		this.wishcategory=categoryBuilder.bwishcategory;
		this.subCategory = categoryBuilder.subCategory;
	}
	
*/	


	@Override
	public String toString() {
		return "WishCategory [wishcategoryId=" + wishcategoryid + ", wishcategory=" + wishcategory + ", subCategory="
				+ wishsubcategory + "]";
	}

/*public static class WishCategotyBuilder{
		
		private int bwishcategoryId;
		private String bwishcategory;
		private List<String> subCategory;
		
		public List<String> getBsubCategory() {
			return subCategory;
		}

		public WishCategotyBuilder subCategory(List<String> subCategory) {
			this.subCategory = subCategory;
			return this;
		}

		public WishCategotyBuilder(int bwishcategoryId,String bwishcategory){
			this.bwishcategoryId = bwishcategoryId;
			this.bwishcategory = bwishcategory;
		}
		
		public WishCategory build(){
			return new WishCategory(this);
		}
		
	}
*/	
}
	
