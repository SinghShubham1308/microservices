package com.gocricket.live.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gocricket.live.model.ApiResponse;
import com.gocricket.live.model.Match;
import com.gocricket.live.model.MatchData;
import com.gocricket.live.model.Score;

/**
 * @author SinghShubham1308
 * 
 */
@Service
public class MatchServiceImpl implements MatchService {
	@Value("${api.url}")
	private String apiUrl;
	@Value("${api.offset}")
	private int apiOffset;
	@Value("${api.key}")
	private String apiKey;
	private final RestTemplate restTemplate;

	public MatchServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public List<Match> getAllMatches() {
		// TODO Auto-generated method stub
		String url = apiUrl + "?apikey=" + apiKey + "&offset=" + apiOffset;
//		System.out.println("api url is "+url);
		ApiResponse response = restTemplate.getForObject(url, ApiResponse.class);
//		System.out.println("api response is "+ response);
		List<Match> resultList = new ArrayList<>();
		if (response == null || response.getData() == null) {
			return resultList;
		}
		for (MatchData matchData : response.getData()) {
			Match match = new Match();
			match.setId(matchData.getId());
			match.setTeamHeading(matchData.getName());
			match.setMatchNumberVenue(matchData.getVenue());
			match.setStatus(matchData.getStatus());
			match.setLiveText(matchData.getStatus());

			List<Score> scoreList = matchData.getScore();
			List<String> teams = matchData.getTeams();

			if (scoreList != null && !scoreList.isEmpty() && teams != null && !teams.isEmpty()) {
				match.setBattingTeam(teams.get(0));
				if (scoreList.size() > 0) {
					match.setBattingTeamScore(getScoreString(scoreList.get(0)));
				}

				if (teams.size() > 1) {
					match.setBowlTeam(teams.get(1));
					if (scoreList.size() > 1) {
						match.setBowlTeamScore(getScoreString(scoreList.get(1)));
					}
				}
			}
			resultList.add(match);
		}
		return resultList;
	}

	@Override
	public List<Match> getLiveMatches() {
		return this.getAllMatches().stream().filter(match -> !match.getStatus().toLowerCase().contains("won by"))
				.toList();
	}

	private String getScoreString(Score score) {
		if (score == null)
			return "";
		return score.getRun() + "/" + score.getWicket() + " (" + score.getOver() + ")";
	}

}
