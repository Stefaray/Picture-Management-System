package Sql;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccessUserdirs {
    public static void init(DruidDataSource dataSource){
        Init.init(dataSource);
    }

    public static void add(String username,String dirs){
        DruidDataSource dataSource = new DruidDataSource();
        init(dataSource);
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        String sql="insert into userdirs(username,dirs) values(?,?)";
        int cnt=jdbcTemplate.update(sql,username,dirs);

        System.out.println("添加了"+cnt+"条userdirs记录");
        dataSource.close();
    }

    public static boolean exists(String username){
        DruidDataSource dataSource = new DruidDataSource();
        init(dataSource);
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        String sql="select count(*) from userdirs where username = ?";
        Integer cnt=jdbcTemplate.queryForObject(sql,Integer.class,username);

        dataSource.close();

        return cnt==1;
    }

    public static void update(String username ,String dirs){
        DruidDataSource dataSource = new DruidDataSource();
        init(dataSource);
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        String sql="update userdirs set dirs=? where username=?";
        int cnt=jdbcTemplate.update(sql,dirs,username);

        System.out.println("更新了"+cnt+"条userdirs记录");
        dataSource.close();
    }

    public static String askDir(String username){
        DruidDataSource dataSource = new DruidDataSource();
        init(dataSource);
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        String sql="select dirs from userdirs where username=?";
        String dirs=jdbcTemplate.queryForObject(sql,String.class,username);

        dataSource.close();
        return dirs;
    }



    public static void main(String[] args) {
        System.out.println(askDir("小王"));
    }

}
