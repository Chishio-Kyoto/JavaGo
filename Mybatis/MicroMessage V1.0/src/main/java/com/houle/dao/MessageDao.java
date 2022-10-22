package com.houle.dao;

import com.houle.bean.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 和message表相关的操作
 */
public class MessageDao {
    String JDBC_URL = "jdbc:mysql://47.101.@@@.@@@:3306/micro_message";
    String JDBC_USER = "@@@@";
    String JDBC_PASSWORD = "@@@@@@@@@@";

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
}
