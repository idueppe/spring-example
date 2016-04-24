package io.crowdcode.speedauction.service;

import io.crowdcode.speedauction.model.Message;

import java.time.Duration;
import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public interface AppLogService {

    void log(String message, Object... args);

    List<Message> lastLogs(Duration duration);

}
