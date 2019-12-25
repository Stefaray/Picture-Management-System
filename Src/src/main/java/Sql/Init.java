package Sql;

import com.alibaba.druid.pool.DruidDataSource;

public class Init {
    public  static  void init(DruidDataSource dataSource){
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(10);
    }
}
