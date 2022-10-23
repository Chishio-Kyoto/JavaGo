package com.houle.service;

import com.houle.bean.Message;
import com.houle.dao.MessageDao;
import com.houle.util.Iconst;

import java.util.List;

/**
 * 查询相关的业务功能
 */
public class QueryService {
    public List<Message> queryMessageList(String command, String description) {
        MessageDao messageDao = new MessageDao();
        return messageDao.queryMessageList(command, description);
    }

    /**
     * 通过指令查询自动回复的内容
     * @param command 指令
     * @return 自动回复的内容
     */
    public String queryByCommand(String command) {
        MessageDao messageDao = new MessageDao();
        List<Message> messageList;
        if(Iconst.HELP_COMMAND.equals(command)) {
            messageList = messageDao.queryMessageList(null, null);
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < messageList.size(); i++) {
                if(i != 0) {
                    result.append("<br/>");
                }
                result.append("回复[").append(messageList.get(i).getCommand()).append("]可以查看").append(messageList.get(i).getDescription());
            }
            return result.toString();
        }
        messageList = messageDao.queryMessageList(command, null);
        if(messageList.size() > 0) {
            return messageList.get(0).getContent();
        }
        return Iconst.NO_MATCHING_CONTENT;
    }
}
