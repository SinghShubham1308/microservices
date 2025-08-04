package com.gocricket.live.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SinghShubham1308
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
	private String apiKey;
	private List<MatchData> data;
	private String status;
	private ApiInfo info;
}
