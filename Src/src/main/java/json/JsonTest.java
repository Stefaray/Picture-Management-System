package json;

import Dao.Image;

import Dao.OpRecord;
import Dao.User;
import Sql.AccessImges;
import Sql.AccessRecord;
import Sql.AccessUserdirs;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.AddressMapping;
import domain.Dir;
import domain.FileItem;

import javax.accessibility.AccessibleSelection;
import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonTest {



    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        List<Image> allImages = AccessImges.findAllImages("小王", "卫星");
        System.out.println(mapper.writeValueAsString(allImages));



    }

}
