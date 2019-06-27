package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Log;

import java.util.List;

public interface LogService {
    List<Log> getLogsByUserId(String userId);

    void insertLog(Log log);
}
