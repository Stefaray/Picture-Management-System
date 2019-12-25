package Sql;

import Dao.Image;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AccessImges {
    public static void init(DruidDataSource dataSource){
        Init.init(dataSource);
    }

    public static void add(Image img){
        DruidDataSource dataSource = new DruidDataSource();
        init(dataSource);
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        String sql="insert into images(image_name,username,dir,image_type,creat_time,image_shape,image_size,modify_time," +
                "resolution,longitude,latitude,location,pick_time,pick_time_long,image_scale,type_star" +
                ") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int cnt=jdbcTemplate.update(sql,img.getName(),img.getUser(),img.getDir(),img.getType(),img.getCreat_time(),
                img.getShape(),img.getSize(),img.getEdit_time(),img.getResolution(),
                img.getLongitude(),img.getLatitude(),img.getLocation(),img.getPick_time(),
                img.getPick_time_long(),img.getScale(),img.getType_star());

        System.out.println("添加了"+cnt+"条images记录");
        dataSource.close();
    }

    public static boolean exists(String image_name,String username,String dir){
        DruidDataSource dataSource = new DruidDataSource();
        init(dataSource);
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        String sql="select count(*) from images where image_name = ? and username=? and dir=?";
        Integer cnt=jdbcTemplate.queryForObject(sql,Integer.class,image_name,username,dir);

        dataSource.close();

        return cnt!=0;
    }


    //修改本地的文件名
    public static void update(Image img,String old_image_name){
        DruidDataSource dataSource = new DruidDataSource();
        init(dataSource);
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        String sql="update images set image_name=?,image_type=?,creat_time=?,image_shape=?,image_size=?,modify_time=?" +
                ",resolution=?,longitude=?,latitude=?,location=?,pick_time=?,pick_time_long=?,image_scale=?,type_star=?" +
                " where image_name=? and username=? and dir=?";
        int cnt=jdbcTemplate.update(sql,img.getName(),img.getType(),img.getCreat_time(),
                img.getShape(),img.getSize(),img.getEdit_time(),img.getResolution(),
                img.getLongitude(),img.getLatitude(),img.getLocation(),img.getPick_time(),
                img.getPick_time_long(),img.getScale(),img.getType_star(),old_image_name,img.getUser(),img.getDir());

        System.out.println("更新了"+cnt+"条images记录");
        dataSource.close();
    }

    public static List<Image> findAllImages(String username, final String dir){
        DruidDataSource dataSource = new DruidDataSource();
        init(dataSource);
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        String sql ="select image_name,username,dir,image_type,creat_time,image_shape,image_size,modify_time,resolution,longitude,latitude,location,pick_time,pick_time_long,image_scale,type_star " +
                "from images where username=? and dir=? ";
        List<Image> list =  jdbcTemplate.query(sql, new RowMapper<Image>() {

            public Image mapRow(ResultSet resultSet, int i) throws SQLException {
                Image image = new Image();
                image.setType(resultSet.getString("image_type"));
                image.setUser(resultSet.getString("username"));
                image.setName(resultSet.getString("image_name"));
                image.setCreat_time(resultSet.getString("creat_time"));
                image.setEdit_time(resultSet.getString("modify_time"));
                image.setLatitude(resultSet.getString("latitude"));
                image.setLocation(resultSet.getString("location"));
                image.setLongitude(resultSet.getString("longitude"));
                image.setScale(resultSet.getString("image_scale"));
                image.setPick_time(resultSet.getString("pick_time"));
                image.setPick_time_long(resultSet.getString("pick_time_long"));
                image.setResolution(resultSet.getString("resolution"));
                image.setShape(resultSet.getString("image_shape"));
                image.setSize(resultSet.getString("image_size"));
                image.setType_star(resultSet.getString("type_star"));
                image.setDir(dir);
                return image;
            }
        }, username, dir);

        dataSource.close();
        return list;
    }



    public static void delImage(String image_name,String username,String dir){
        DruidDataSource dataSource = new DruidDataSource();
        init(dataSource);
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        String sql="delete from images where image_name=? and username=? and dir=?";
        int cnt=jdbcTemplate.update(sql,image_name,username,dir);
        System.out.println("删除了条"+cnt+"image");
        dataSource.close();
    }

    public static void main(String[] args) {
//        Image image=new Image();
//        image.setName("3.jpg");
//        image.setUser("小王");
//        image.setDir("卫星");
//        add(image);
        System.out.println(exists("5642.jpg_wh300.jpg","小王","卫星"));
    }
    
}
