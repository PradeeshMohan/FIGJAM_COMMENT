package com.framework.lib.utils;

import java.util.HashMap;

public class VariablePool {
    private static final HashMap<String, Object> variablePool = new HashMap<>();

    public Object getVariable(String key) {
        if (variablePool.isEmpty()) {
            return null;
        } else if (variablePool.containsKey(key)) {
            return variablePool.get(key);
        }
        return null;
    }

    public void setVariable(String key, Object obj) {
        variablePool.put(key, obj);
    }
}
