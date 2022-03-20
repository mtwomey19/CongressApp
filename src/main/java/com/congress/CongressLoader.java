package com.congress;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.util.*;

public class CongressLoader {

    private File file;

    public CongressLoader(String filePath) {
        this.file = new File(filePath); //
    }

    public List<CongressMember> loadCongressMember() {
        // Jackson ObjectMapper class used for converting JSON strings into Java objects
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        mapper.registerModule(new JavaTimeModule());

        try {
            // create array of CongressMember objects from reading JSON file
            CongressMember[] congressMemberArray = mapper.readValue(file, CongressMember[].class);
            List<CongressMember> congressMemberList = Arrays.asList(congressMemberArray); // convert to list
            return congressMemberList;
        } catch(Exception e) {
            System.err.println("Cannot find file that matches the file path entered.\n" + e.getMessage());
        }
        return null;
    }
}
