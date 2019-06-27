package org.csu.mypetstore.domain;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {
    private static final long serialVersionUID = 1492634752670189553L;

    private int logId;
    private String userId;
    private Date logTime;
    private String userAction;

    public Log(){

    }
    public Log(String userId,Date logTime,String userAction){
        setUserId(userId);
        setLogTime(logTime);
        setUserAction(userAction);
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getUserAction() {
        return userAction;
    }

    public void setUserAction(String userAction) {
        this.userAction = userAction;
    }



}
