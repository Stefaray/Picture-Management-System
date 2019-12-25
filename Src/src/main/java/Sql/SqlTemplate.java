package Sql;

import Dao.User;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class SqlTemplate {
   public static void init(DruidDataSource dataSource){
      Init.init(dataSource);
   }

     public static void addUser(User u){
        DruidDataSource dataSource = new DruidDataSource();
        init(dataSource);
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        String sql="insert into learn(username,password,email,gender,time_register) values(?,?,?,?,?)";
        int aInt = jdbcTemplate.update(sql,u.getUsername(),u.getPassword(),u.getEmail(),u.getGender()
                ,u.getTime_register());
        System.out.println("添加了"+aInt+"条用户记录");
         dataSource.close();
    }
    public static Integer findTotalCount(){
       DruidDataSource dataSource = new DruidDataSource();
       init(dataSource);
       JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

       String sql="select count(*) from learn";
        Integer count=jdbcTemplate.queryForObject(sql,Integer.class);
        dataSource.close();
       return count;
    }

    public static List<User> findAllUsers(){
       DruidDataSource dataSource = new DruidDataSource();
       init(dataSource);
       JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

       String sql="select * from learn";
       List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));

       dataSource.close();

       return list;
   }

   public static boolean existUser(String username){
      DruidDataSource dataSource = new DruidDataSource();
      init(dataSource);
      JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

      String sql="select count(*) from learn where username = ?";
      Integer cnt=jdbcTemplate.queryForObject(sql,Integer.class,username);
      dataSource.close();
      return cnt==1;
   }

   public static User findUser(String username){
      DruidDataSource dataSource = new DruidDataSource();
      init(dataSource);
      JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

      String sql="select * from learn where username = ?";
      User user=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username);
       dataSource.close();
      return user;
   }

   public static void delUser(String username){
      DruidDataSource dataSource = new DruidDataSource();
      init(dataSource);
      JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

      String sql="delete from learn where username = ?";
      int aInt = jdbcTemplate.update(sql,username);
      System.out.println("删除了"+aInt+"条用户记录");
       dataSource.close();
   }
   public static void updateUser(User u){
      DruidDataSource dataSource = new DruidDataSource();
      init(dataSource);
      JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

      String sql="update learn set email=?,gender=?,time_register=?,boss=? where username=?";
      int aInt = jdbcTemplate.update(sql,u.getEmail(),u.getGender()
              ,u.getTime_register(),u.getBoss(),u.getUsername());
      System.out.println("更新了"+aInt+"条用户记录");
       dataSource.close();
   }

   public static void creadtUser(User u){
      DruidDataSource dataSource = new DruidDataSource();
      init(dataSource);
      JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
      u.setPassword("123");
      String sql="insert into learn(username,password,email,gender,time_register,boss) values(?,?,?,?,?,?)";
      int aInt = jdbcTemplate.update(sql,u.getUsername(),u.getPassword(),u.getEmail(),
              u.getGender(),u.getTime_register(),u.getBoss());
      System.out.println("创建了"+aInt+"个用户");
      dataSource.close();
   }

   public static void main(String[] args) {

      System.out.println(findUser("000"));
   }

}
