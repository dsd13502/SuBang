package net.oschina.app.bean;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 收藏实体类
 * @author hww
 *
 */
@SuppressWarnings("serial")
@XStreamAlias("favorite")
public class Favorite implements Serializable {
	
	public static final int CATALOG_SOFTWARE = 0;
	public static final int CATALOG_TOPIC = 1;
	public static final int CATALOG_CODE = 2;
	public static final int CATALOG_BLOGS = 3;
	public static final int CATALOG_NEWS = 4;
	
	@XStreamAlias("objid")
	public int objid;
	@XStreamAlias("type")
	public int type;
	@XStreamAlias("title")
	public String title;
	@XStreamAlias("url")
	public String url;
	public int getObjid() {
		return objid;
	}
	public void setObjid(int objid) {
		this.objid = objid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}