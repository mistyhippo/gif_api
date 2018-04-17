package gif.services;


import gif.exceptions.GeneralException;
import gif.mappers.UserMapper;
import gif.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    SecurityService securityService;

    public ArrayList<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    public User getUserById(int id) throws GeneralException {
        User u = userMapper.getByID(id);
        if (u == null){
            throw new GeneralException("User not found");
        }

        return u;
    }

    public User createUser(User user) throws NoSuchAlgorithmException, GeneralException {
        String apiKey = securityService.generateApiKey(128);
        user.setApiKey(apiKey);
        int success = userMapper.insertUser(user);

        if (success == 1){
            User u = userMapper.getByName(user.getFirstName(), user.getLastName());
            return u;
        } else {
            throw new GeneralException("User Not Created.");
        }
    }




}
