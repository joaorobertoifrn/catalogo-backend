package br.com.helpc.catalogo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	@ManyToMany
	@JoinTable(name = "MOVIE_GENRE",
		joinColumns = @JoinColumn(name = "movie_id"),
		inverseJoinColumns = @JoinColumn(name = "genre_id")
	)
	private List<Genre> genres = new ArrayList<>();

	public Movie(Integer id, String overview, Double popularity, Integer vote_count, Boolean video, String poster_path,
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

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adult == null) ? 0 : adult.hashCode());
		result = prime * result + ((backdrop_path == null) ? 0 : backdrop_path.hashCode());
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((original_language == null) ? 0 : original_language.hashCode());
		result = prime * result + ((original_title == null) ? 0 : original_title.hashCode());
		result = prime * result + ((overview == null) ? 0 : overview.hashCode());
		result = prime * result + ((popularity == null) ? 0 : popularity.hashCode());
		result = prime * result + ((poster_path == null) ? 0 : poster_path.hashCode());
		result = prime * result + ((release_date == null) ? 0 : release_date.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((video == null) ? 0 : video.hashCode());
		result = prime * result + ((vote_average == null) ? 0 : vote_average.hashCode());
		result = prime * result + ((vote_count == null) ? 0 : vote_count.hashCode());
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
		Movie other = (Movie) obj;
		if (adult == null) {
			if (other.adult != null)
				return false;
		} else if (!adult.equals(other.adult))
			return false;
		if (backdrop_path == null) {
			if (other.backdrop_path != null)
				return false;
		} else if (!backdrop_path.equals(other.backdrop_path))
			return false;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (original_language == null) {
			if (other.original_language != null)
				return false;
		} else if (!original_language.equals(other.original_language))
			return false;
		if (original_title == null) {
			if (other.original_title != null)
				return false;
		} else if (!original_title.equals(other.original_title))
			return false;
		if (overview == null) {
			if (other.overview != null)
				return false;
		} else if (!overview.equals(other.overview))
			return false;
		if (popularity == null) {
			if (other.popularity != null)
				return false;
		} else if (!popularity.equals(other.popularity))
			return false;
		if (poster_path == null) {
			if (other.poster_path != null)
				return false;
		} else if (!poster_path.equals(other.poster_path))
			return false;
		if (release_date == null) {
			if (other.release_date != null)
				return false;
		} else if (!release_date.equals(other.release_date))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (video == null) {
			if (other.video != null)
				return false;
		} else if (!video.equals(other.video))
			return false;
		if (vote_average == null) {
			if (other.vote_average != null)
				return false;
		} else if (!vote_average.equals(other.vote_average))
			return false;
		if (vote_count == null) {
			if (other.vote_count != null)
				return false;
		} else if (!vote_count.equals(other.vote_count))
			return false;
		return true;
	}

}
