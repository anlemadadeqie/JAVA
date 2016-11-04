package com.ttms.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Created by hjh on 16-10-30.
 */
/*数据库连接操作类，使用c3p0连接池*/
public final class ConnectionManager {

    private static ConnectionManager instance = null;
    private static ComboPooledDataSource ds;


    static {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        ds = new ComboPooledDataSource();
        try{
            ds.setDriverClass(rb.getString("driver"));
        }catch (Exception e){
            e.printStackTrace();
        }

        ds.setJdbcUrl(rb.getString("url"));
        ds.setUser(rb.getString("name"));
        ds.setPassword(rb.getString("password"));
    }


    //获取实例
    public synchronized static final ConnectionManager getInstance(){
        if(instance == null){
            try{
                instance = new ConnectionManager();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return instance;
    }


    //获取数据库连接
    public synchronized final Connection getConnection(){
        try{
            return ds.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    //关闭连接
    public static void close(ResultSet rs, Statement stmt, Connection con){
        try{
            if(rs != null)
                rs.close();
            if(stmt != null)
                stmt.close();
            if(con != null)
                con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    //释放数据库资源
    protected void finalize() throws Throwable {
        DataSources.destroy(ds);
        super.finalize();
    }



}
