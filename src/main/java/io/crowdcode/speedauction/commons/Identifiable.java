package io.crowdcode.speedauction.commons;

import java.io.Serializable;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public interface Identifiable<ID extends Serializable> {

    ID getId();

    void setId(ID id);

}
