package br.com.jirayatv.core.xml.model;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class Video {

	@XStreamConverter(value=BooleanConverter.class, booleans={false}, strings={"yes", "no"})
	private Boolean colour;
	

	public Boolean getColour() {
		return colour;
	}

	public void setColour(Boolean colour) {
		this.colour = colour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
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
		Video other = (Video) obj;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		return true;
	}
	
}
