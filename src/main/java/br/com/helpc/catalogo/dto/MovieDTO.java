package br.com.helpc.catalogo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class MovieDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String overview;
	
	private Double popularity;

	private Integer vote_count;
	
	private Boolean video;
	
	private String poster_path;
	
	private Boolean adult;
	
	private String backdrop_path;
	
	private String original_language;
	
	private String original_title;
	
	private String title;
	
	private Double vote_average;
	
	private Date release_date;

	public MovieDTO(Integer id, String overview, Double popularity, Integer vote_count, Boolean video, String poster_path,
			Boolean adult, String backdrop_path, String original_language, String original_title, String title,
			Double vote_average, Date release_date) {
		super();
		this.id = id;
		this.overview = overview;
		this.popularity = popularity;
		this.vote_count = vote_count;
		this.video = video;
		this.poster_path = poster_path;
		this.adult = adult;
		this.backdrop_path = backdrop_path;
		this.original_language = original_language;
		this.original_title = original_title;
		this.title = title;
		this.vote_average = vote_average;
		this.release_date = release_date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public Double getPopularity() {
		return popularity;
	}

	public void setPopularity(Double popularity) {
		this.popularity = popularity;
	}

	public Integer getVote_count() {
		return vote_count;
	}

	public void setVote_count(Integer vote_count) {
		this.vote_count = vote_count;
	}

	public Boolean getVideo() {
		return video;
	}

	public void setVideo(Boolean video) {
		this.video = video;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	public Boolean getAdult() {
		return adult;
	}

	public void setAdult(Boolean adult) {
		this.adult = adult;
	}

	public String getBackdrop_path() {
		return backdrop_path;
	}

	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}

	public String getOriginal_language() {
		return original_language;
	}

	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}

	public String getOriginal_title() {
		return original_title;
	}

	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getVote_average() {
		return vote_average;
	}

	public void setVote_average(Double vote_average) {
		this.vote_average = vote_average;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

}
