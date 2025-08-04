package com.gocricket.live.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SinghShubham1308
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchData {
	private String id;
	private String name;
	private String matchType;
	private String status;
	private String venue;
	private String date;
	private String dateTimeGMT;
	private List<String> teams;
	private List<TeamInfo> teamInfo;
	private List<Score> score;
	private String series_id;
	private boolean fantasyEnabled;
	private boolean bbbEnabled;
	private boolean hasSquad;
	private boolean matchStarted;
	private boolean matchEnded;

	public MatchData(String id, String name, String status, String venue) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.venue = venue;
	}

}
