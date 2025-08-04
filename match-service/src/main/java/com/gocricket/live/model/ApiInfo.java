package com.gocricket.live.model;

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
public class ApiInfo {
	private int hitsToday;
	private int hitsUsed;
	private int hitsLimit;
	private int credits;
	private int server;
	private int offsetRows;
	private int totalRows;
	private double queryTime;
	private int s;
	private int cache;
}
