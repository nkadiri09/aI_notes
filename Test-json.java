package com.naren.kadiri.chatdemo.match;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonCompareExample {

    public static void main(String[] args) throws Exception {

        // Expected policyInputs
        String expectedJson = """
        {
          "policyInputs":[
            {
              "inputVariableID": "associateDefferalAmount",
              "inputValue": {
                "amount": 9500,
                "currencyCode": "USD"
              }
            },
            {
              "inputVariableID": "taxabilityCode",
              "inputValue": "TRADITIONAL"
            }
          ]
        }
        """;

        // Actual response - may have additional fields
        String actualJson = """
        {"policyTypeID": "401k", "policyoptionID": "DeferralContribution", "clientOptionInstanceID": "a8Qkznu6XDEsfjZX", "associateOptionInstanceID": "2BDAcwZ02yI7kbhy", "clientInputInstanceID": "pBp0MqPWflrxvvXp", "calculationMethodID": "AssociateBaseDeferralFixedAmount", "excludeFromGrossUp": false, "policyInputs":[{"inputVariableID": "associateDefferalAmount","inputValue": {"amount": 9500,"currencyCode": "USD"}},{"inputVariableID": "taxabilityCode","inputValue": "TRADITIONAL"}]}
        """;

        boolean isEqual = comparePolicyInputs(expectedJson, actualJson);
        System.out.println("policyInputs Equal: " + isEqual);

        // Example: Convert API response string to JsonNode
        String apiResponse = """
        {"policyTypeID": "401k", "policyoptionID": "DeferralContribution", "clientOptionInstanceID": "a8Qkznu6XDEsfjZX", "associateOptionInstanceID": "2BDAcwZ02yI7kbhy", "clientInputInstanceID": "pBp0MqPWflrxvvXp", "calculationMethodID": "AssociateBaseDeferralFixedAmount", "excludeFromGrossUp": false, "policyInputs":[{"inputVariableID": "associateDefferalAmount","inputValue": {"amount": 9500,"currencyCode": "USD"}},{"inputVariableID": "taxabilityCode","inputValue": "TRADITIONAL"}]}
        """;

        JsonNode responseNode = convertToJsonNode(apiResponse);
        System.out.println("Converted to JsonNode: " + responseNode);

        // Extract policyInputs from the response
        JsonNode policyInputs = responseNode.get("policyInputs");
        System.out.println("policyInputs: " + policyInputs);
    }

    /**
     * Converts an API response string to JsonNode.
     */
    public static JsonNode convertToJsonNode(String jsonString) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(jsonString);
    }

    /**
     * Compares only the "policyInputs" array between two JSON strings.
     * Ignores all other fields in the JSON objects.
     */
    public static boolean comparePolicyInputs(String expectedJson, String actualJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode expectedNode = mapper.readTree(expectedJson);
        JsonNode actualNode = mapper.readTree(actualJson);

        // Extract only the policyInputs array from each JSON
        JsonNode expectedPolicyInputs = expectedNode.get("policyInputs");
        JsonNode actualPolicyInputs = actualNode.get("policyInputs");

        if (expectedPolicyInputs == null || actualPolicyInputs == null) {
            System.out.println("One or both JSON objects missing 'policyInputs' field");
            return false;
        }

        return expectedPolicyInputs.equals(actualPolicyInputs);
    }
}
