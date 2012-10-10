package br.com.jirayatv.core.model;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class BaseModel {

	private String clazz = this.getClass().getSimpleName();
	private String _id;
	private String _rev;

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String get_rev() {
		return _rev;
	}

	public void set_rev(String _rev) {
		this._rev = _rev;
	}
	
}
