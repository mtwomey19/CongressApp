package com.congress;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.time.Year;
import java.util.*;

public class CongressMember {
    @JsonIgnore
    private String firstName;
    @JsonIgnore
    private String lastName;
    @JsonIgnore
    private LocalDate birthday;
    @JsonIgnore
    private String gender;
    @JsonProperty("terms")
    private List<Term> termList;


    public CongressMember(){}

    // Overloaded constructor to manually create politicians for testing
    public CongressMember(String firstName, String lastName, String birthday, String gender, List<Term> termList){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = LocalDate.parse(birthday);
        this.gender = gender;
        this.termList = termList;
    }

    @JsonSetter("name")
    public void setName(Map<String, String> name){
        this.firstName = name.get("first");
        this.lastName = name.get("last");
    }

    @JsonSetter("bio")
    public void setBio(Map<String, String> bio){
        this.birthday = LocalDate.parse(bio.get("birthday"));
        this.gender = bio.get("gender");
    }

    public List<Term> getTermList(){
        return this.termList;

    }
    public String toString(){
        return ("First Name: " + this.firstName + "\n" +
                "Last Name: " + this.lastName + "\n" +
                "Birthday: " + this.birthday + "\n" +
                "Gender: " + this.gender + "\n\n" +
                "First Term: \n" + this.termList.get(0) + "\n");
    }

    public String getName(){
        String name = "";
        name = this.firstName.toLowerCase() + " " + this.lastName.toLowerCase();
        return name;
    }

    public int getCongressMemberAge(){
        int birthYear = this.birthday.getYear();
        int congressMemberAge = Year.now().getValue() - birthYear;
        return congressMemberAge;
    }

    public int getCongressMemberTimeInOffice(){
        int numberOfYearsInOffice = 0;
        int yearsOfTerm = 0;

        for (Term term : this.termList){
            if (term.getEndDate() > LocalDate.now().getYear())
                yearsOfTerm = LocalDate.now().getYear() - term.getStartDate();
            else {
                yearsOfTerm = term.getEndDate() - term.getStartDate();
            }
            numberOfYearsInOffice = numberOfYearsInOffice + yearsOfTerm;
        }
        return numberOfYearsInOffice;
    }
}


