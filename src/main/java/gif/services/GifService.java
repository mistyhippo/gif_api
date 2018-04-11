package gif.services;
import gif.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GifService {

    @Autowired
    RestTemplate restTemplate;

   public GifRoot mapGifs(){

    String fQuery = "https://api.tenor.com/v1/search?key=8XMHTIMHEAUV";
    GifRoot rootObject = restTemplate.getForObject(fQuery,GifRoot.class);

    return rootObject;

    }

    public GifRoot searchGifs(String query){

       String fQuery = "https://api.tenor.com/v1/search?key=8XMHTIMHEAUV&q=" + query;

       GifRoot rootObject2 = restTemplate.getForObject(fQuery,GifRoot.class);

       return rootObject2;
    }

    public void databaseLoad(GifRoot rootObject3){


       Results[] arrayOfResults = rootObject3.getResults();

       for(Results resultsObject : arrayOfResults){

           Database databaseobj = new Database();

           String title = resultsObject.getTitle();
           databaseobj.setTitle(title);

           int shares = resultsObject.getShares();
           databaseobj.setShares(shares);

           String url = resultsObject.getUrl();
           databaseobj.setWeburl(url);

           Media[] mediaArray = resultsObject.getMedia();
           Media mediaObject = mediaArray[0];
           Nanomp4 nanomp4Object = mediaObject.getNanomp4();
           double duration = nanomp4Object.getDuration();
           databaseobj.setDuration(duration);



       }

    }


}
