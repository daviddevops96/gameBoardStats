package org.teamcifo.logic;


import lombok.Data;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import org.teamcifo.domain.*;;


@Data
@AllArgsConstructor
@Getter
@Setter
public class UserManager{

    private static Map<String, User> users = new HashMap<>();

    /*
    public UserManager(){
        this.users= new HashMap<>();
    }
*/
    public static void addUser(User user) {

        users.put(user.getUserId(), user);
    }

    public static User getUser(String userId) {
        return users.get(userId);
    }

    public static boolean authenticate(String userId, String password) {
        User user = users.get(userId);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }

    public static void updateUser(User user) {
        users.put(user.getUserId(), user);
    }

    public static void deleteUser(String userId) {
        users.remove(userId);
    }

    public static Map<String,User> getAllUsers() { return users; }

    public static void Clear(){
        users.clear();
    }
}


