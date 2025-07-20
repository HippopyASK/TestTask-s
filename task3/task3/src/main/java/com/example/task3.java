package com.example;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class task3 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println(" <src\\main\\resources\\values.json> <src\\main\\resources\\tests.json> <src\\main\\resources\\report.json>");
            return;
        }

        String valuesPath = args[0];
        String testsPath = args[1];
        String reportPath = args[2];

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode valuesNode = mapper.readTree(new File(valuesPath));
            
            Map<Integer, String> valuesMap = new HashMap<>();
            for (JsonNode val : valuesNode.get("values")) {
                int id = val.get("id").asInt();
                String value = val.get("value").asText();
                valuesMap.put(id, value);
            }

            
            JsonNode testsNode = mapper.readTree(new File(testsPath));
            
            for (JsonNode test : testsNode.get("tests")) {
                fillValues(test, valuesMap);
            }

            
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(reportPath), testsNode);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fillValues(JsonNode node, Map<Integer, String> valuesMap) {
        if (node.has("id")) {
            int id = node.get("id").asInt();
            if (node.has("value")) {
                ((com.fasterxml.jackson.databind.node.ObjectNode) node).put("value", valuesMap.getOrDefault(id, ""));
            }
        }
        if (node.has("values")) {
            for (JsonNode child : node.get("values")) {
                fillValues(child, valuesMap);
            }
        }
    }
}