package com.congress;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class Term {

    @JsonProperty("start")
    private LocalDate startDate;

    @JsonProperty("end")
    private LocalDate endDate;

    @JsonProperty("type")
    private String chamber;

    @JsonProperty("state")
    private String state;

    @JsonProperty("party")
    private String party;

    public Term() {}

    // overloaded constructor to manually create a Term object
    public Term(String startDate, String endDate, String chamber, String state, String party) {
        this.startDate = LocalDate.parse(startDate);
        this.endDate = LocalDate.parse(endDate);
        this.chamber = chamber;
        this.state = state;
        this.party = party;
    }

    public String toString() {
        return ("Term Start Date: " + startDate + "\n" +
                "Term End Date: " + endDate + "\n" +
                "Chamber: " + chamber + "\n" +
                "State: " + state + "\n" +
                "Party: " + party);
    }

    public String getParty() {
        return party;
    }

    public int getStartDate() {
        int termStartYear = startDate.getYear();
        return termStartYear;
    }

    public int getEndDate() {
        int termEndYear = endDate.getYear();
        return termEndYear;
    }
}
