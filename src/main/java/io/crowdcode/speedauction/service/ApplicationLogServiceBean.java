package io.crowdcode.speedauction.service;

import io.crowdcode.speedauction.model.Message;
import io.crowdcode.speedauction.repository.ApplicationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */

@Service
public class ApplicationLogServiceBean implements ApplicationLogService {

    @Autowired
    private ApplicationLogRepository logRepository;


    @Override
    public void log(String message, Object... args) {
        String msg = String.format(message, args);
        String username = "TO_BE_DEFINED";

        logRepository.log(msg, LocalDateTime.now(), username);
    }

    @Override
    public List<Message> lastLogs(Duration duration) {
        LocalDateTime to = LocalDateTime.now();
        LocalDateTime from = to.minus(duration);

        return logRepository.findLogs(from, to);
    }
}
