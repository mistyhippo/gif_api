package gif.mappers;

import gif.models.User;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface UserMapper {

    String GET_ALL__ACTIVE_USERS = "SELECT * FROM `gif`.users where isActive = 1";
    String GET_BY_ID = "SELECT * FROM `gif`.users where id = #{id}";

    String AUTHENTICATE = "SELECT isActive from `gif`.users where apiKey = #{apiKey}";

    String INSERT_USER = "INSERT INTO `gif`.users (firstName, lastName, email, apiKey) " +
            "VALUES (#{firstName}, #{lastName}, #{email}, #{apiKey})";

    String GET_BY_NAME = "SELECT * FROM `gif`.users where firstName = #{arg0} and lastName = #{arg1}";



    @Select(GET_ALL__ACTIVE_USERS)
    public ArrayList<User> getAllUsers();

    @Select(GET_BY_ID)
    public User getByID(int id);

    @Insert(INSERT_USER)
    public int insertUser(User user);

    @Select(AUTHENTICATE)
    boolean authenticate(String apiKey);

    @Select(GET_BY_NAME)
    public User getByName(String fname, String lname);
}
