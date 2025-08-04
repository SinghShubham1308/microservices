package com.gocricket.live.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SinghShubham1308
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    private String id;
    private String teamHeading;
    private String matchNumberVenue;
    private String battingTeam;
    private String battingTeamScore;
    private String bowlTeam;
    private String bowlTeamScore;
    private String liveText;
    private String status;
    private Date date = new Date();
}
