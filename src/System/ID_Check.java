package System;

public class ID_Check {

    public static boolean isIDExists(String id) {
    	
        return Database_Manager.isIDExists(id);
    }
}