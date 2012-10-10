package br.com.jirayatv.core.xml.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class Programme {

	@XStreamAsAttribute
	private String start;
	@XStreamAsAttribute
	private String stop;
	@XStreamAsAttribute
	private String channel;
	@XStreamAlias("program_id")
   	@XStreamAsAttribute
	private String programId;
	@XStreamImplicit(itemFieldName = "title")
	private List<Title> titles;
	private String desc;
	@XStreamImplicit(itemFieldName = "category")
	private List<Category> categories;
	private String country;
	private Video video;
	private Rating rating;
	@XStreamAlias("sub-title")
	private SubTitle subTile;
	@XStreamAlias("episode-num")
	@XStreamImplicit(itemFieldName = "episode-num")
	private List<EpisodeNum> episodesNum;
	private Credits credits;
	@XStreamAlias("date")
	private String ano;
	@XStreamAlias("star-rating")
	private StarRating starRating;
	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getStop() {
		return stop;
	}
	public void setStop(String stop) {
		this.stop = stop;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	public List<Title> getTitles() {
		return titles;
	}
	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Credits getCredits() {
		return credits;
	}
	public void setCredits(Credits credits) {
		this.credits = credits;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public StarRating getStarRating() {
		return starRating;
	}
	public void setStarRating(StarRating starRating) {
		this.starRating = starRating;
	}
	public SubTitle getSubTile() {
		return subTile;
	}
	public void setSubTile(SubTitle subTile) {
		this.subTile = subTile;
	}
	public List<EpisodeNum> getEpisodesNum() {
		return episodesNum;
	}
	public void setEpisodesNum(List<EpisodeNum> episodesNum) {
		this.episodesNum = episodesNum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result
				+ ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((credits == null) ? 0 : credits.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result
				+ ((episodesNum == null) ? 0 : episodesNum.hashCode());
		result = prime * result
				+ ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result
				+ ((starRating == null) ? 0 : starRating.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((stop == null) ? 0 : stop.hashCode());
		result = prime * result + ((subTile == null) ? 0 : subTile.hashCode());
		result = prime * result + ((titles == null) ? 0 : titles.hashCode());
		result = prime * result + ((video == null) ? 0 : video.hashCode());
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
		Programme other = (Programme) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		if (channel == null) {
			if (other.channel != null)
				return false;
		} else if (!channel.equals(other.channel))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (credits == null) {
			if (other.credits != null)
				return false;
		} else if (!credits.equals(other.credits))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (episodesNum == null) {
			if (other.episodesNum != null)
				return false;
		} else if (!episodesNum.equals(other.episodesNum))
			return false;
		if (programId == null) {
			if (other.programId != null)
				return false;
		} else if (!programId.equals(other.programId))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (starRating == null) {
			if (other.starRating != null)
				return false;
		} else if (!starRating.equals(other.starRating))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (stop == null) {
			if (other.stop != null)
				return false;
		} else if (!stop.equals(other.stop))
			return false;
		if (subTile == null) {
			if (other.subTile != null)
				return false;
		} else if (!subTile.equals(other.subTile))
			return false;
		if (titles == null) {
			if (other.titles != null)
				return false;
		} else if (!titles.equals(other.titles))
			return false;
		if (video == null) {
			if (other.video != null)
				return false;
		} else if (!video.equals(other.video))
			return false;
		return true;
	}
	
}
