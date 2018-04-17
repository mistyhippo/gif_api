package gif.controllers;

import gif.exceptions.AuthenticationException;
import gif.exceptions.GeneralException;
import gif.models.GifRoot;
import gif.models.User;
import gif.services.GifService;
import gif.services.SecurityService;
import gif.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

/*
Todo:
1. Check if entry is already in database before inserting that
    - create new mapper method that selects where (weburl = weburl and title = title etc.) to see if it is in the dB
    - if it is in the DB, skip inserting it
    - if not, insert it into DB
2. Implement API auth
 */

@RestController
@RequestMapping("/gif")
public class GifController {

    @Autowired
    GifService gifService;

    @Autowired
    SecurityService securityService;

    @Autowired
    UserService userService;

    @RequestMapping("/all")
    public GifRoot allGifs(@RequestParam("api-key") String apiKey)throws AuthenticationException {

        if (securityService.authenticateApiKey(apiKey)){
            GifRoot object = gifService.mapGifs();
            return object;
        }

        else
            throw new AuthenticationException("Invalid API Key.");


    }

    @RequestMapping("/search")
    public GifRoot searchGifs(@RequestParam(value = "query", defaultValue = "")String query,
                              @RequestParam("api-key") String apiKey)throws AuthenticationException{

        if (securityService.authenticateApiKey(apiKey)){
            GifRoot object2 = gifService.searchGifs(query);

            return object2;
        }

        else
            throw new AuthenticationException("Invalid API Key.");

    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws GeneralException, NoSuchAlgorithmException {

        return userService.createUser(user);
    }

}
