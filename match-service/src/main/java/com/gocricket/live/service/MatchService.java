package com.gocricket.live.service;

import java.util.List;

import com.gocricket.live.model.Match;

public interface MatchService {

	List<Match> getAllMatches();

	List<Match> getLiveMatches();
}
