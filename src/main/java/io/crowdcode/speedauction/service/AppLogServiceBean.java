package io.crowdcode.speedauction.service;

import io.crowdcode.speedauction.model.Message;
import io.crowdcode.speedauction.repository.AppLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static io.crowdcode.speedauction.commons.AnsiColor.red;

/**
 * @author Ingo Düppe (Crowdcode)
 */

@Service
public class AppLogServiceBean implements AppLogService {

    private static final Logger log = LoggerFactory.getLogger(AppLogServiceBean.class);

    @Autowired(required = false)
    private AppLogRepository logRepository;

    public AppLogServiceBean() {
        log.info(red("========================= AppLogServiceBean construct! ========="));
    }

    @PostConstruct
    public void init() {
        log.info(red("========================= AppLogServiceBean init! ========="));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void log(String message, Object... args) {
        String msg = String.format(message, args);
        String username = "System";
        logRepository.log(msg, LocalDateTime.now(), username);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Message> lastLogs(Duration duration) {
        LocalDateTime to = LocalDateTime.now();
        LocalDateTime from = to.minus(duration);

        return logRepository.findLogs(from, to);
    }
}
