package gif.controllers;

import gif.models.GifRoot;
import gif.services.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gif")
public class GifController {

@Autowired
    GifService gifService;

    @RequestMapping("/all")
    public GifRoot allGifs(){

      GifRoot object = gifService.mapGifs();
      return object;
    }

    @RequestMapping("/search")
    public GifRoot searchGifs(@RequestParam(value = "query", defaultValue = "")String query){


        GifRoot object2 = gifService.searchGifs(query);

        return object2;
    }

}
