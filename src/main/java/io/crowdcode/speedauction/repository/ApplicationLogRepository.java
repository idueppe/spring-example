package io.crowdcode.speedauction.repository;

import io.crowdcode.speedauction.model.Message;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public interface ApplicationLogRepository {

    void log(String message, LocalDateTime loggedAt, String username);

    List<Message> findLogs(LocalDateTime from, LocalDateTime to);
}
