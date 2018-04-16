package gif.services;
import gif.mappers.GifMapper;
import gif.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GifService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    GifMapper gifMapper;

   public GifRoot mapGifs(){

    String fQuery = "https://api.tenor.com/v1/search?key=8XMHTIMHEAUV";
    GifRoot rootObject = restTemplate.getForObject(fQuery,GifRoot.class);

    databaseLoad(rootObject);

    return rootObject;

    }

    public GifRoot searchGifs(String query){

       String fQuery = "https://api.tenor.com/v1/search?key=8XMHTIMHEAUV&q=" + query;

       GifRoot rootObject2 = restTemplate.getForObject(fQuery,GifRoot.class);

       return rootObject2;
    }

    //method takes in GifRoot object. doesn't return anything
    public void databaseLoad(GifRoot rootObject3){

       //rootObject gets results from api and sets equal to results array
        // called arrayOfResults

       Results[] arrayOfResults = rootObject3.getResults();

       //create for loop to get all objects from api and set them equal
        //variables that can be mapped to the database

       for(Results resultsObject : arrayOfResults){

           //each time it loops a new database object is being created
           GifDbObj databaseobj = new GifDbObj();

           //within the resultsObject we get the title and set it equal
           //to an instance variable and mapped to the database object
           String title = resultsObject.getTitle();
           databaseobj.setTitle(title);

           //within the resultsObject we get shares and pass to databaseob
           int shares = resultsObject.getShares();
           databaseobj.setShares(shares);

           //see above
           String url = resultsObject.getUrl();
           databaseobj.setWeburl(url);

           //Media array contains only one object at index of 0
           //these objects are nanomp4 and duration
           Media[] mediaArray = resultsObject.getMedia();
           Media mediaObject = mediaArray[0];
           Nanomp4 nanomp4Object = mediaObject.getNanomp4();
           double duration = nanomp4Object.getDuration();
           databaseobj.setDuration(duration);


           //calling insertGif method and passing the databaseobj
           //that was created in this loop and setting it equal to
           //success variable. does nothing now

           int success = gifMapper.insertGif(databaseobj);
       }

    }


}
