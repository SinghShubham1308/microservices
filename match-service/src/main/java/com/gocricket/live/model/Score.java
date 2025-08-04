package com.gocricket.live.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class Score {
	@JsonProperty("r")
	private int run;
	@JsonProperty("w")
	private int wicket;
	@JsonProperty("o")
	private int over;
	private String inning;
}
