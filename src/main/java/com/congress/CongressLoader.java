package com.congress;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.util.*;

public class CongressLoader {

    private File file;

    public CongressLoader(String filePath){
        this.file = new File(filePath);
    }

    public List<CongressMember> loadCongressMember() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        mapper.registerModule(new JavaTimeModule());

        // Loading data from JSON file into a list
        try {
            CongressMember[] congressMemberArray = mapper.readValue(file, CongressMember[].class);
            List<CongressMember> congressMemberList = Arrays.asList(congressMemberArray);
            return congressMemberList;
        } catch(Exception e) {
            System.err.println("Cannot find file that matches the file path entered.\n" + e.getMessage());
        }
        return null;
    }
}
