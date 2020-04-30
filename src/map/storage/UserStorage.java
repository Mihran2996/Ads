package map.storage;

import map.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {

    public Map<String, User> users = new HashMap<>();

    public boolean login(String phoneNUmber, String passvord) {
        if (passvord.equals(users.get(phoneNUmber).getPassword())) {
            return true;
        }
        throw new  NullPointerException();
    }

}

