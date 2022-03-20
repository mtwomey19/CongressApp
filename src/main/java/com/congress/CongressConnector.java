package com.congress;

// CongressConnector serves as link between congress-related classes and user interface classes

public class CongressConnector {
    private static CongressLoader congressLoader = new CongressLoader("src/main/resources/json/CongressMembers.json");
    private static CongressAnalyzer congressAnalyzer = new CongressAnalyzer(congressLoader.loadCongressMember());

    // provides access to CongressAnalyzer class without having to create a new object in user interface classes
    public static CongressAnalyzer getAnalyzerAccess() {
        return congressAnalyzer;
    }

    // serves as utility function, preventing the need for CongressLoader objects to be created in user interface classes
    public static int getCongressListSize() { return congressLoader.loadCongressMember().size(); }

}
