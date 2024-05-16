package System;

import java.util.HashMap;
import java.util.Map;

public class User_Manager {
    private static Map<String, User> users = new HashMap<>();

    public static void addUser(String username, String password) {
        User user = new User(username, password);
        users.put(username, user);
    }
    
    public static boolean isValidUser(String input, String password) {
        for (User user : users.values()) {
            if (input.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isUserExists(String input) {
        return users.containsKey(input);
    }
}
