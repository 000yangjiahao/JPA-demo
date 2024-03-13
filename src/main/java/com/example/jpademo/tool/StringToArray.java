package com.example.jpademo.tool;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StringToArray {

    public List<Long> convert(String string){
        List<Long> resultList = new ArrayList<>();

        if (string == null || string.isEmpty()) {
            return resultList;
        }

        String[] strArray = string.split(",");

        for (String numStr : strArray) {
            try {
                long num = Long.parseLong(numStr.trim());
                resultList.add(num);
            } catch (NumberFormatException e) {
                System.err.println("Error converting string to long: " + numStr);
            }
        }

        return resultList;
    }
}
