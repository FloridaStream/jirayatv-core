package br.com.jirayatv.core.xml.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;


/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
@XStreamAlias("tv")
public class Tv {

	@XStreamImplicit(itemFieldName = "channel")
	private List<Channel> channels;
	private String provider;
	@XStreamImplicit(itemFieldName = "programme")
	private List<Programme> programmes;
	
	
	
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	public List<Channel> getChannels() {
		return channels;
	}
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
	public List<Programme> getProgrammes() {
		return programmes;
	}
	public void setProgrammes(List<Programme> programmes) {
		this.programmes = programmes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((channels == null) ? 0 : channels.hashCode());
		result = prime * result
				+ ((programmes == null) ? 0 : programmes.hashCode());
		result = prime * result
				+ ((provider == null) ? 0 : provider.hashCode());
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
		Tv other = (Tv) obj;
		if (channels == null) {
			if (other.channels != null)
				return false;
		} else if (!channels.equals(other.channels))
			return false;
		if (programmes == null) {
			if (other.programmes != null)
				return false;
		} else if (!programmes.equals(other.programmes))
			return false;
		if (provider == null) {
			if (other.provider != null)
				return false;
		} else if (!provider.equals(other.provider))
			return false;
		return true;
	}
	
	
}
