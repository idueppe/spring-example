package io.crowdcode.speedauction.service;

import io.crowdcode.speedauction.exception.BadWordException;
import io.crowdcode.speedauction.exception.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class BadWordValidatorBean implements BadWordValidator {

    private static final Logger log = LoggerFactory.getLogger(BadWordValidatorBean.class);

    @Value("classpath:badWords.txt")
    private Resource badWordsFile;

    private List<String> badWords;

    @PostConstruct
    private void postConstruct() {
        log.info("init topic serivce");

        try (InputStream is = badWordsFile.getInputStream();
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader bufferedReader = new BufferedReader(isr)) {

            badWords = bufferedReader.lines().map(line -> line.split(",\\s+"))
                    .distinct().flatMap(Arrays::stream)
                    .collect(Collectors.toList());
            log.info("found bad words: {}", Arrays.toString(badWords.toArray()));

        } catch (IOException e) {
            throw new SystemException("Could not read BadWords", e);
        }
    }

    @Override
    public void checkBadWords(String title) throws BadWordException {
        if (title != null && badWords != null) {
            for (String badWord : badWords) {
                if (title.contains(badWord)) {
                    throw new BadWordException(badWord);
                }
            }
        }
    }

    @Override
    public boolean isInvalid(String title) {
        if (title != null && badWords != null) {
            for (String badWord : badWords) {
                if (title.contains(badWord)) {
                    return true;
                }
            }
        }
        return false;
    }

}
