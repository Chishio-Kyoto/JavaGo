package com.houle.dao;

import com.houle.bean.Message;
import com.houle.db.DBAccess;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.io.IOException;
// import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.apache.log4j.Logger.getLogger;

/**
 * 和message表相关的操作
 */
public class MessageDao {

    // 注意导包：org.apache.log4j.Logger
    static Logger logger = getLogger(MessageDao.class);

    /**
     * 根据查询条件查询消息列表
     */
    public List<Message> queryMessageList(String command, String description){
        DBAccess dbAccess = new DBAccess();
        List<Message> messageList = new ArrayList<>();
        logger.debug("debug：进入queryMessageList方法");
        try (SqlSession sqlSession = dbAccess.getSqlSession()) {
            Message message = new Message();
            message.setCommand(command);
            message.setDescription(description);

            // 通过sqlSession执行SQL语句
            messageList = sqlSession.selectList("Message.queryMessageList", message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return messageList;
    }

    /**
     * 单条删除
     */
    public void deleteOne(int id) {
        logger.debug("debug：进入deleteOne方法");
        DBAccess dbAccess = new DBAccess();
        try (SqlSession sqlSession = dbAccess.getSqlSession()) {
            // 通过sqlSession执行SQL语句
            sqlSession.delete("Message.deleteOne", id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        logger.debug("debug：进入deleteBatch方法");
        DBAccess dbAccess = new DBAccess();
        try (SqlSession sqlSession = dbAccess.getSqlSession()) {
            // 通过sqlSession执行SQL语句
            sqlSession.delete("Message.deleteBatch", ids);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MessageDao messageDao = new MessageDao();
        messageDao.queryMessageList("查看", "精彩内容");
    }

    /*
    String JDBC_URL = "jdbc:mysql://47.101.210.145:3306/micro_message";
    String JDBC_USER = "work";
    String JDBC_PASSWORD = "2023@Japan";

    public List<Message> queryMessageList(String command, String description) {

        List<Message> messageList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功");

            // 获取连接:
            try(Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
                StringBuilder sql = new StringBuilder("SELECT ID, COMMAND, DESCRIPTION, CONTENT FROM message");
                List<String> paramList = new ArrayList<>();
                if (command != null && !"".equals(command.trim())) {
                    sql.append(" WHERE COMMAND=?");
                    paramList.add(command);
                }
                if (description != null && !"".equals(description.trim())) {
                    sql.append(" WHERE DESCRIPTION LIKE '%' ? '%'");
                    paramList.add(description);
                }
                try (PreparedStatement preparedStatement = conn.prepareStatement(String.valueOf(sql))) {
                    for (int i = 0; i < paramList.size(); i++) {
                        preparedStatement.setString(i + 1, paramList.get(i));
                    }
                    ResultSet rs = preparedStatement.executeQuery();
                    while(rs.next()) {
                        Message message = new Message();
                        messageList.add(message);
                        message.setId(rs.getString("ID"));
                        message.setCommand(rs.getString("COMMAND"));
                        message.setDescription(rs.getString("DESCRIPTION"));
                        message.setContent(rs.getString("CONTENT"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return messageList;
    }
    */
}
