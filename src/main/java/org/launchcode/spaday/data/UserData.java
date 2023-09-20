package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserData {
    public static final Map<Integer, User> user = new HashMap<>();

    public static Collection<User> getAll(){return user.values();}

    public static User getById(int id){
        return user.get(id);
    }

//    public static void add(User user){
//        user.(user.getId(), user);
//    }
}
