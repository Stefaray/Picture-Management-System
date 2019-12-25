package image;

import Dao.Image;
import Dao.OpRecord;
import Service.ReturnDate;
import Sql.AccessImges;
import Sql.AccessRecord;

import javax.servlet.ServletException;
import java.io.IOException;

//前端对图片进行了修改


public class PostImagesToMysql{

    public static void process(String op,Image image,String old_image_name) throws ServletException, IOException {

        OpRecord record=new OpRecord();
        record.setUsername(image.getUser());
        record.setItem_type("图片");
        record.setItem_name(image.getName());
        record.setModify_time(ReturnDate.returnDate());
        if(op.equals("add")){
            AccessImges.add(image);
            record.setOperation("添加了");
        }
        else if(op.equals("delete")){
            AccessImges.delImage(image.getName(),image.getUser(),image.getDir());
            record.setOperation("删除了");
        }else if(op.equals("edit")){
            AccessImges.update(image,old_image_name);
            record.setOperation("修改了");
        }
        AccessRecord.add(record);
        if(AccessRecord.totalCount()>50){
            AccessRecord.delHalf();
        }

    }



    public static void main(String[] args) {

    }
}
