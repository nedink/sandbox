package com.nedink.sandbox.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandsMap {
    public static Map<String, CommandType> commandTypeMap = new HashMap<>();
    static {
        commandTypeMap.put("go", CommandType.GO);
        commandTypeMap.put("l", CommandType.LEFT);
        commandTypeMap.put("r", CommandType.RIGHT);

        commandTypeMap.put("take", CommandType.TAKE);
        commandTypeMap.put("t", CommandType.TAKE);

        commandTypeMap.put("q", CommandType.QUIT);
    }
}
