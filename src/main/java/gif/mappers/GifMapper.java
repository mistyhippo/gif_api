package gif.mappers;


import gif.models.GifDbObj;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;


@Mapper
public interface GifMapper {


    String INSERT_DBOBJ = "INSERT INTO `gif`.gifs (weburl, duration, shares, title) " +
            "VALUES (#{weburl}, #{duration}, #{shares}, #{title})";


    @Insert(INSERT_DBOBJ)
    public int insertGif(GifDbObj gifDbObj);


}
