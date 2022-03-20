package com.congress;

import java.util.*;

public class CongressAnalyzer {

    private List<CongressMember> congressMemberList;

    public CongressAnalyzer(List<CongressMember> congressMemberList) {
        this.congressMemberList = congressMemberList;
    }

    public CongressMember findCongressMemberByName(String firstName, String lastName) {
        String congressMemberNameIn = firstName.toLowerCase() + " " + lastName.toLowerCase();

        for (CongressMember congressMember : congressMemberList) {
            if (congressMember.getName().equals(congressMemberNameIn))
                return congressMember;
        }
        System.out.println("Could not find a congress person with that name.");
        return null;
    }

    public int numberOfCongressMembersInParty(String party) {
        int democratCount = 0, republicanCount = 0, independentCount = 0;
        List<Term> termList = new ArrayList<>();

        // adding the most recent term to termList for most accurate results (some members of Congress have switched parties)
        for (CongressMember congressMember : congressMemberList)
            termList.add(congressMember.getTermList().get(congressMember.getTermList().size()-1));
        // moving through termList to count number of Congress members in each
        for (Term term : termList) {
            if (term.getParty().equals("Democrat")) democratCount += 1;
            if (term.getParty().equals("Republican")) republicanCount += 1;
            if (term.getParty().equals("Independent")) independentCount += 1;
        }
        // returning result based on user-entered party
        if (party.equalsIgnoreCase("democrat")) return democratCount;
        if (party.equalsIgnoreCase("republican")) return republicanCount;
        if (party.equalsIgnoreCase("independent")) return independentCount;
        else return -1;
    }

    public List<CongressMember> oldestCongressMembers(int topN) {
        List<CongressMember> oldestCongressMember = congressMemberList; // making copy of list before alterations
        // Sorting list from oldest to youngest
        for (int firstCM = 0; firstCM < oldestCongressMember.size(); firstCM++) {
            for (int secondCM = firstCM + 1; secondCM < oldestCongressMember.size(); secondCM++) {
                if (oldestCongressMember.get(firstCM).getCongressMemberAge() < oldestCongressMember.get(secondCM).getCongressMemberAge()) {
                    CongressMember temp = oldestCongressMember.get(firstCM);
                    oldestCongressMember.set(firstCM, oldestCongressMember.get(secondCM));
                    oldestCongressMember.set(secondCM, temp);
                }
            }
        }
        // making topN oldest list
        List<CongressMember> topNOldestCongressMembers = new ArrayList<>();
        for (int i = 0; i < topN; i++)
            topNOldestCongressMembers.add(oldestCongressMember.get(i));

        // printing topN oldest Congress members
        int count = 0;
        for (CongressMember congressMember : topNOldestCongressMembers) {
            count++;
            System.out.println(
                    "rank: " + count + "\n" +
                    "name: " + congressMember.getName() + "\n" +
                    "age: " + congressMember.getCongressMemberAge() + "\n");
        }
        return topNOldestCongressMembers;
    }

    public HashMap<String, Double> averageAgeByParty() {
        HashMap<String, Double> averageAgeByParty = new HashMap<>();
        List<Integer> democratAgeList = new ArrayList<>();
        List<Integer> republicanAgeList = new ArrayList<>();
        List<Integer> independentAgeList = new ArrayList<>();

        // Ages of Congress members are placed into the appropriate lists based on their current party
        for (int i = 0; i < congressMemberList.size(); i++) {

            List<Term> termList = congressMemberList.get(i).getTermList();
            String party = congressMemberList.get(i).getTermList().get(termList.size()-1).getParty();
            int age = congressMemberList.get(i).getCongressMemberAge();

            if (party.equals("Democrat")) democratAgeList.add(age);
            if (party.equals("Republican")) republicanAgeList.add(age);
            if (party.equals("Independent")) independentAgeList.add(age);
        }
        // Sum of ages calculation
        int democratAges, republicanAges, independentAges;
        democratAges = sumAge(democratAgeList);
        republicanAges = sumAge(republicanAgeList);
        independentAges = sumAge(independentAgeList);

        // Average age calculations
        double avgAgeDemocrat, avgAgeRepublican, avgAgeIndependent;
        avgAgeDemocrat = calculateAvgAge(democratAgeList, democratAges);
        avgAgeRepublican = calculateAvgAge(republicanAgeList, republicanAges);
        avgAgeIndependent = calculateAvgAge(independentAgeList, independentAges);

        // adding ages to hash map
        averageAgeByParty.put("Democrat", avgAgeDemocrat);
        averageAgeByParty.put("Republican", avgAgeRepublican);
        averageAgeByParty.put("Independent", avgAgeIndependent);

        return averageAgeByParty;
    }

    private int sumAge(List<Integer> ageList) {
        int total = 0;
        for (int i = 0; i < ageList.size(); i++)
            total += ageList.get(i);
        return total;
    }
    private double calculateAvgAge(List<Integer> partyAgeList, double sumAge) {
        if (partyAgeList.size() > 0)
            return Math.round(sumAge / partyAgeList.size());
        else return 0;
    }

    public List<CongressMember> CongressPeopleTimeInOfficeSorted(int topN) {
        List<CongressMember> timeInOffice = congressMemberList; // making copy of list before alterations

        // sorting congress people list by time in office (greatest to least) so the list can be reduced properly in the next step
        for (int firstCM = 0; firstCM < timeInOffice.size(); firstCM++) {
            for (int secondCM = firstCM + 1; secondCM < timeInOffice.size(); secondCM++) {
                if (timeInOffice.get(firstCM).getCongressMemberTimeInOffice() < timeInOffice.get(secondCM).getCongressMemberTimeInOffice()) {
                    CongressMember temp = timeInOffice.get(firstCM);
                    timeInOffice.set(firstCM, timeInOffice.get(secondCM));
                    timeInOffice.set(secondCM, temp);
                }
            }
        }
        // reducing list to topN
        List<CongressMember> topNTimeInOffice = new ArrayList<>();
        for (int i = 0; i < topN; i++)
            topNTimeInOffice.add(timeInOffice.get(i));

        return topNTimeInOffice;
    }
}
