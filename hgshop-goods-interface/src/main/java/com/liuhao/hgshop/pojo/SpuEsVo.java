package com.liuhao.hgshop.pojo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * 用于检索es 
 * @author 刘浩
 *
 */
@Document(indexName="hgshopindex",type="goods")
public class SpuEsVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2082762585944624675L;
	
	@Id
	private Integer	id; 
	
	private String	goodsName;
	//private String	isMarketable; // 是否上线
	private int	brandId;  //品牌
	private String	caption; // 标题
	private int	categoryId; // 分类
	private String	smallPic; //小图
	private String	brandName;
	private String categoryName;
	
	
	public SpuEsVo(Spu spu) {
		super();
		this.id=spu.getId();
		this.goodsName=spu.getGoodsName();
		this.brandId=spu.getBrandId();
		this.caption=spu.getCaption();
		this.smallPic=spu.getSmallPic();
		this.categoryId=spu.getCategoryId();
		this.brandName=spu.getBrand()==null?"":spu.getBrand().getName();
		this.categoryName=spu.getCategory()==null?"":spu.getCategory().getName();
		
	}
	
	
	public SpuEsVo() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SpuEsVo other = (SpuEsVo) obj;
		if (goodsName == null) {
			if (other.goodsName != null)
				return false;
		} else if (!goodsName.equals(other.goodsName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "SpuEsVo [id=" + id + ", goodsName=" + goodsName + ", brandId=" + brandId + ", caption=" + caption
				+ ", categoryId=" + categoryId + ", smallPic=" + smallPic + ", brandName=" + brandName
				+ ", categoryName=" + categoryName + "]";
	}


	public String getBrandName() {
		return brandName;
	}


	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getSmallPic() {
		return smallPic;
	}
	public void setSmallPic(String smallPic) {
		this.smallPic = smallPic;
	}
	
	
	
	
}
