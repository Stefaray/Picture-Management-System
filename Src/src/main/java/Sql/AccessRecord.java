package Sql;


import Dao.OpRecord;
import Dao.User;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccessRecord {
    static int id=0;
    public static void init(DruidDataSource dataSource){
        Init.init(dataSource);
    }
    public static void add(OpRecord record){
        DruidDataSource dataSource = new DruidDataSource();
        init(dataSource);
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        String sql="insert into user_op_record(id,username,operation,item_name,item_type,modify_time) values(?,?,?,?,?,?)";
        int cnt=jdbcTemplate.update(sql,AccessRecord.id,record.getUsername(),record.getOperation(),record.getItem_name(),record.getItem_type(),record.getModify_time());

        System.out.println("添加了"+cnt+"条user_op_record记录");
        dataSource.close();
    }

    public static List<OpRecord> findAllRecords(){
        DruidDataSource dataSource = new DruidDataSource();
        init(dataSource);
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        String sql="select * from user_op_record";
        List<OpRecord> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<OpRecord>(OpRecord.class));

        dataSource.close();

        return list;
    }

    public static Integer totalCount(){
        DruidDataSource dataSource = new DruidDataSource();
        init(dataSource);
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        String sql="select count(*) from user_op_record";
        Integer cnt=jdbcTemplate.queryForObject(sql,Integer.class);
        dataSource.close();
        return cnt;
    }
    public static void delHalf(){
        DruidDataSource dataSource = new DruidDataSource();
        init(dataSource);
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        String sql="select count(*) from user_op_record";
        Integer cnt=jdbcTemplate.queryForObject(sql,Integer.class);
        String sql_baseId="select id from user_op_record limit 1;";
        Integer base_id=jdbcTemplate.queryForObject(sql_baseId,Integer.class);
//        System.out.println(base_id);
        int del_cnt=cnt/2;
        String del_sql="delete  from user_op_record where id<?";
        int update = jdbcTemplate.update(del_sql, del_cnt+base_id);
        System.out.println("删除了"+update+"条record记录");
        dataSource.close();
    }


    public static void main(String[] args) {
        delHalf();
    }
}
