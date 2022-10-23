package com.houle.service;

import com.houle.bean.Message;
import com.houle.dao.MessageDao;

import java.util.List;

/**
 * 列表相关的服务功能
 */
public class ListService {
    public List<Message> queryMessageList(String command, String description) {
        MessageDao messageDao = new MessageDao();
        return messageDao.queryMessageList(command, description);
    }
}
