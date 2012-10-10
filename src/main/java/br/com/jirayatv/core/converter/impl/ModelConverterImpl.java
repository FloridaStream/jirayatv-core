package br.com.jirayatv.core.converter.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import br.com.jirayatv.core.converter.ModelConverter;
import br.com.jirayatv.core.model.Canal;
import br.com.jirayatv.core.model.Categoria;
import br.com.jirayatv.core.model.Classificacao;
import br.com.jirayatv.core.model.Guia;
import br.com.jirayatv.core.model.I18N;
import br.com.jirayatv.core.model.Programa;
import br.com.jirayatv.core.model.Titulo;
import br.com.jirayatv.core.xml.model.Category;
import br.com.jirayatv.core.xml.model.Channel;
import br.com.jirayatv.core.xml.model.EpisodeNum;
import br.com.jirayatv.core.xml.model.Programme;
import br.com.jirayatv.core.xml.model.Title;
import br.com.jirayatv.core.xml.model.Tv;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class ModelConverterImpl implements ModelConverter{

	
	private Date inicio;
	private Date fim;
	
	/**
	 * Entra um objeto Tv que foi baseado no xml e saira um Guia muito mais enxuto.
	 */
	@Override
	public Guia convert(Tv tv) {
		Guia guia = new Guia();
		guia.setCanais(this.convertCanais(tv.getChannels()));
		guia.setProgramas(this.convertProgramas(tv.getProgrammes()));
		guia.setInicio(this.inicio);
		guia.setFim(this.fim);
		return guia;
	}

	
	private List<Programa> convertProgramas(List<Programme> programmes) {
		List<Programa> programas = new ArrayList<Programa>();
		
		for (Programme programme : programmes) {
			Programa p = new Programa();
			p.setAno(programme.getAno());
			p.setDescricao(programme.getDesc());
			p.setFim(this.parseDate(programme.getStop()));
			p.setInicio(this.parseDate(programme.getStart()));
			
			this.saveInicio(p.getInicio());
			this.saveFim(p.getFim());
			
			p.set_id(programme.getProgramId());
			p.setIdCanal(programme.getChannel());
			p.setPais(programme.getCountry());
			
			this.convertCredits(programme, p);
			this.convertCategory(programme, p);
			this.convertRating(programme, p);
			this.convertEpisodes(programme, p);
			this.convertStarRating(programme, p);
			this.convertSubTitle(programme, p);
			this.convertTitles(programme, p);
			
			programas.add(p);
			
		}
		return programas;
	}

	private void convertTitles(Programme programme, Programa p) {
		if (programme.getTitles() != null){
			List<Titulo> titulos = new ArrayList<Titulo>(programme.getTitles().size());
			for (Title title : programme.getTitles()){
				Titulo t = new Titulo();
				t.setLinguagem(I18N.getLinguagemByName(title.getLang()));
				t.setNome(title.getContent());
				titulos.add(t);
			}
			p.setTitulos(titulos);
		}
	}

	private void convertSubTitle(Programme programme, Programa p) {
		if (programme.getSubTile() != null){
			Titulo t = new Titulo();
			t.setLinguagem(I18N.getLinguagemByName(programme.getSubTile().getLang()));
			t.setNome(programme.getSubTile().getContent());
			p.setSubTitulo(t);
		}
	}

	private void convertStarRating(Programme programme, Programa p) {
		if (programme.getStarRating() != null){
			p.setStarClassificacao(programme.getStarRating().getValue());
		}
	}

	private void convertEpisodes(Programme programme, Programa p) {
		if (programme.getEpisodesNum() != null){
			//pegando apenas o sistema da xmltv_ns porque tem a temporada e o episodio ex: 7.10 (Temporada 7 capitulo 10).
			for (EpisodeNum episode : programme.getEpisodesNum()){
				if ("xmltv_ns".equalsIgnoreCase(episode.getContent())){
					p.setEpsodio(episode.getContent());
				}
			}
		}
	}

	private void convertRating(Programme programme, Programa p) {
		if ( programme.getRating() != null ){
			Classificacao c = new Classificacao();
			c.setNome(programme.getRating().getValue());
			c.setSistema(programme.getRating().getSystem());
			p.setClassificacao(c);
		}
	}

	private void convertCategory(Programme programme, Programa p) {
		if (programme.getCategories() != null){
			List<Categoria> categorias = new ArrayList<Categoria>(programme.getCategories().size());
			for (Category category : programme.getCategories()) {
				Categoria c = new Categoria();
				c.setLinguagem(I18N.getLinguagemByName(category.getLang()));
				c.setNome(category.getContent());
				categorias.add(c);
			}
			p.setCategorias(categorias);
		}
	}

	private void convertCredits(Programme programme, Programa p) {
		if (programme.getCredits() != null){
			p.setAtores(programme.getCredits().getActors());
			p.setDiretores(programme.getCredits().getDirectors());
		}
	}

	
	
	private Date parseDate(String date) {
		
		if (StringUtils.isNotBlank(date)){
			//retiramos o gmt para parsear a data.
			String semGmt = date.replaceAll(" -[0-9]+", "");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			try {
				return sdf.parse(semGmt);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private String formatDate(Date date) {
		return formatDate(date,"yyyyMMddHHmm");
	}
	
	private String formatDate(Date date, String p) {
		SimpleDateFormat sdf = new SimpleDateFormat(p);
		return sdf.format(date);
	}
	
	
	private List<Canal> convertCanais(List<Channel> channels) {
		List<Canal> canais = new ArrayList<Canal>(channels.size());
		for (Channel channel : channels) {
			Canal c = new Canal();
			c.set_id(channel.getId());
			if (channel.getDisplayName() != null){
				c.setLinguagem(I18N.getLinguagemByName(channel.getDisplayName().getLang()));
				c.setNome(channel.getDisplayName().getContent());
			}
			c.setNumero(channel.getDisplayNumber());
			if (channel.getIcon() != null){
				c.setSrcIcon(channel.getIcon().getSrc());
			}
			canais.add(c);
		}
		
		return canais;
	}
	
	
	private void saveInicio(Date data){
		
		if (data == null){
			return;
		}
		
		if (this.inicio == null){
			this.inicio = data;
		}
		
		if (this.inicio.compareTo(data) > 0){
			this.inicio = data;
		}
	}
	
	private void saveFim(Date data){
		
		if (data == null){
			return;
		}
		
		if (this.fim == null){
			this.fim = data;
		}
		
		if (this.fim.compareTo(data) < 0){
			this.fim = data;
		}
		
	}

}

