package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Log;
import java.util.List;

public interface LogMapper {

  List<Log> getLogsByUserId(String userId);

  void insertLog(Log log);

}