package com.congress;

public class CongressConnector {
    private static CongressLoader congressLoader = new CongressLoader("src/main/resources/json/CongressMembers.json");
    private static CongressAnalyzer congressAnalyzer = new CongressAnalyzer(congressLoader.loadCongressMember());

    public static CongressAnalyzer getAnalyzerAccess() {
        return congressAnalyzer;
    }
    public static int getCongressListSize() { return congressLoader.loadCongressMember().size(); }

}
