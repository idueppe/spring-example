package io.crowdcode.speedauction.service;

import io.crowdcode.speedauction.exception.BadWordException;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public interface BadWordValidator {

    void checkBadWords(String title) throws BadWordException;

    boolean isInvalid(String title);
}
