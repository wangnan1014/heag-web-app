package com.wang.core.helper;

import com.wang.core.util.CollectionUtil;
import com.wang.core.util.PropsUtil;
import com.wang.core.util.StringUtil;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2017/7/9.
 * 数据库操作助手类
 */
public class DatabaseHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseHelper.class);
    private static final QueryRunner QUERY_RUNNER;
    private static final ThreadLocal<Connection> CONNECTION_HOLDER ;
    private static final BasicDataSource DATA_SOURCE;
    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
    private static final int INITIASIZE;//定义初始连接数
    private static final int MAXACTION;//定义最大连接数
    private static final int MAXIDLE;//定义最大空闲
    private static final int MINIDLE;//定义最小空闲
    private static final long MAXWAIT;//定义最长等待时间

    static{
        Properties props= PropsUtil.loadProps("jdbc.properties");
        DRIVER = PropsUtil.getString(props,"driver");
        URL = PropsUtil.getString(props,"url");
        USERNAME = PropsUtil.getString(props,"username");
        PASSWORD =  PropsUtil.getString(props,"password");
        INITIASIZE = PropsUtil.getInt(props,"initialSize");
        MAXACTION = PropsUtil.getInt(props,"maxActive");
        MAXIDLE = PropsUtil.getInt(props,"maxIdle");
        MINIDLE = PropsUtil.getInt(props,"minIdle");
        MAXWAIT = PropsUtil.getLong(props,"maxWait");
        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            LOGGER.error("can not load jdbc driver",e);
        }

        CONNECTION_HOLDER= new ThreadLocal<Connection>();
        QUERY_RUNNER = new QueryRunner();
        DATA_SOURCE = new BasicDataSource();
        DATA_SOURCE.setDriverClassName(DRIVER);
        DATA_SOURCE.setUrl(URL);
        DATA_SOURCE.setUsername(USERNAME);
        DATA_SOURCE.setPassword(PASSWORD);
        DATA_SOURCE.setInitialSize(INITIASIZE);
        DATA_SOURCE.setMaxActive(MAXACTION);
        DATA_SOURCE.setMaxIdle(MAXIDLE);
        DATA_SOURCE.setMaxIdle(MAXIDLE);
        DATA_SOURCE.setMaxWait(MAXWAIT);
    }
    /**
     * 获取数据库连接
     */
    public static Connection getConnection()  {
        Connection conn = CONNECTION_HOLDER.get();
        if(conn!=null){
            try {
                //conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                conn = DATA_SOURCE.getConnection();//用数据池的技术
            }catch(SQLException e){
                LOGGER.error("get Connection failure",e);
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.set(conn);
            }
        }
        return conn;
    }
    /**
     *关闭数据连接
     */
//    public static void closeConnection(){
//        Connection conn= CONNECTION_HOLDER.get();
//        if(conn!=null){
//            try {
//                conn.close();
//            }catch (SQLException e){
//                LOGGER.error("close connection failure",e);
//                throw new RuntimeException(e);
//            } finally {
//                CONNECTION_HOLDER.remove();
//            }
//        }
//    }
    /**
     * 查询实体列表
     */
    public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params){
        List<T> entityList = null;
        try {
            Connection conn = CONNECTION_HOLDER.get();
            entityList = QUERY_RUNNER.query(conn,sql,new BeanListHandler<T>(entityClass),params);
        }catch(SQLException e){
            LOGGER.error("query entity list failure",e);
            throw new RuntimeException(e);
        }
        return entityList;
    }
    /**
     * 查询实体
     * DbUtils 为我们提供了许多的类似的Handler，除以上两种，其它的有：
     * BeanMapHandler、 ArrayHandler、 ArrayListHandler、 MapHandler、MapListHandler、
     * ScalarHandler（返回某列的值）、
     * ColumnListHandler（返回某列的值列表）、
     * KeyedHandler（返回Map>对象）
     * 以上这些Handler 都实现ResultSetHandler
     */
    public static <T> T queryEntity(Class<T> entityClass, String sql, Object... params){
        T entity = null;
        try {
            Connection conn = CONNECTION_HOLDER.get();
            entity = QUERY_RUNNER.query(conn,sql,new BeanHandler<T>(entityClass),params);
        }catch(SQLException e){
            LOGGER.error("query entity failure",e);
            throw new RuntimeException(e);
        }
        return entity;
    }

    /**
     * 执行查询语句
     * @param sql
     * @param params
     * @return
     */
    public static List<Map<String,Object>> executeQuery(String sql,Object...params){
        List<Map<String,Object>> result=null;
        try{
            Connection conn = CONNECTION_HOLDER.get();
            result = QUERY_RUNNER.query(conn,sql,new MapListHandler(),params);
        }catch (SQLException e){
            LOGGER.error("execute query failure"+sql,e);
            throw new RuntimeException(e);
        }

        return result;
    }

    /**
     * 执行更新语句(包括insert，update，delete)
     * @param sql
     * @param params
     * @return
     */
    public static int executeUpdate(String sql,Object...params){
        int rows = 0;
        try{
            Connection conn = CONNECTION_HOLDER.get();
            rows = QUERY_RUNNER.update(conn,sql,params);
        }catch (SQLException e){
            LOGGER.error("execute update failure："+sql,e);
            throw new RuntimeException(e);
        }
        return rows;
    }

    /**
     * 插入实体类
     * @param entityClass
     * @param fieldMap
     * @param <T>
     * @return
     */
    public static <T> boolean insertEntity(Class<T> entityClass,Map<String,Object> fieldMap){
        if(CollectionUtil.isEmpty(fieldMap)){
            LOGGER.error("can not insert entity: fieldMap is empty");
            return false;
        }
        String sql ="insert into " + getTableName(entityClass);
        StringBuilder columns = new StringBuilder("(") ;
        StringBuilder values = new StringBuilder("(") ;
        for (String filedName :fieldMap.keySet()) {
            columns.append(filedName).append(",");
            values.append("?,");
        }
        columns.replace(columns.lastIndexOf(","),columns.length(),")");
        values.replace(values.lastIndexOf(","),values.length(),")");
        sql +=columns.toString()+" VALUES " + values.toString();
        Object[] params = fieldMap.values().toArray() ;
        return executeUpdate(sql,params) == 1;
    }

    /**
     * 更新实体类
     * @param entityClass
     * @param id
     * @param fieldMap
     * @param <T>
     * @return
     */
    public static <T> boolean updateEntity(Class<T> entityClass,long id,Map<String,Object> fieldMap){
        if(CollectionUtil.isEmpty(fieldMap)){
            LOGGER.error("can not update entity: fieldMap is empty");
            return false;
        }
        String sql ="update " + getTableName(entityClass) +" set ";
        StringBuilder columns = new StringBuilder() ;
        for (String filedName :fieldMap.keySet()) {
            columns.append(filedName).append("=?,");
        }
        columns.replace(columns.lastIndexOf(","),columns.length()," where id=?");
        sql +=columns.toString();
        List<Object> paramList = new ArrayList<Object>();
        paramList.addAll(paramList);
        paramList.add(id);
        return executeUpdate(sql,paramList.toArray()) == 1;
    }

    /**
     * 删除实体
     * @param entityClass
     * @param id
     * @param <T>
     * @return
     */
    public static <T> boolean deleteEntity(Class<T> entityClass,long id){
        String sql = "delete from "+getTableName(entityClass) +" where id=?";
        return executeUpdate(sql,id) == 1;
    }

    private static String getTableName(Class<?> entityClass){
        return  entityClass.getSimpleName();
    }

}
