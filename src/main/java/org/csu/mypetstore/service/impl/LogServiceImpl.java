package org.csu.mypetstore.service.impl;

import org.csu.mypetstore.domain.Log;
import org.csu.mypetstore.persistence.LogMapper;
import org.csu.mypetstore.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {


    @Autowired
    LogMapper logMapper;

    @Override
    public List<Log> getLogsByUserId(String userId) {
        return logMapper.getLogsByUserId(userId);
    }

    @Override
    public void insertLog(Log log) {
        logMapper.insertLog(log);
    }
}
