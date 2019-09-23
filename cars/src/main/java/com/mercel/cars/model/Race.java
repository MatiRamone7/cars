package com.mercel.cars.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "race")
public class Race {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "session_id")
	@JsonIgnore
	private Session session;

	@ManyToOne
	@JoinColumn(name = "track_id")
	private Track track;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "race")
	private List<RaceResult> results;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public List<RaceResult> getResults() {
		return results;
	}

	public void setResults(List<RaceResult> results) {
		this.results = results;
	}
}
