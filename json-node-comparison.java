
    private static boolean deepEqualsIgnoreArrayOrder(JsonNode node1, JsonNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        // If both are arrays, compare ignoring order
        if (node1.isArray() && node2.isArray()) {
            if (node1.size() != node2.size()) {
                return false;
            }
            // For each element in node1, find a matching element in node2
            boolean[] matched = new boolean[node2.size()];
            for (JsonNode element1 : node1) {
                boolean foundMatch = false;
                for (int i = 0; i < node2.size(); i++) {
                    if (!matched[i] && deepEqualsIgnoreArrayOrder(element1, node2.get(i))) {
                        matched[i] = true;
                        foundMatch = true;
                        break;
                    }
                }
                if (!foundMatch) {
                    return false;
                }
            }
            return true;
        }

        // If both are objects, compare all fields deeply
        if (node1.isObject() && node2.isObject()) {
            if (node1.size() != node2.size()) {
                return false;
            }
            var fieldNames = node1.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                if (!node2.has(fieldName)) {
                    return false;
                }
                if (!deepEqualsIgnoreArrayOrder(node1.get(fieldName), node2.get(fieldName))) {
                    return false;
                }
            }
            return true;
        }

        // For primitive values, use standard equals
        return node1.equals(node2);
    }
