package io.crowdcode.speedauction.repository.inmemory;

import io.crowdcode.speedauction.commons.Identifiable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Component
public class InMemoryStore<T extends Identifiable<Long>> {

    private static final Logger log = LoggerFactory.getLogger(InMemoryStore.class);

    private Map<Long, T> store;

    private Long sequence = 0l;

    public InMemoryStore() {
        store = new HashMap<>();
    }

    public void init() {
        sequence = System.currentTimeMillis();
        log.info("initialized in memory store with sequence {} ", sequence);
    }

    public void save(T entity) {
        if (entity.getId() == null) {
            entity.setId(nextId());
        }
        store.put(entity.getId(), entity);
    }

    public void delete(long id) {
        store.remove(id);
    }

    public List<T> loadAll() {
        return new ArrayList<T>(store.values());
    }

    public T load(long id) {
        return store.get(id);
    }

    synchronized public long nextId() {
        return sequence++;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

    public List<T> find(Predicate<T> predicate) {
        return loadAll().stream().filter(predicate).collect(Collectors.toList());
    }

    public void clear() {
        store.clear();
    }
}