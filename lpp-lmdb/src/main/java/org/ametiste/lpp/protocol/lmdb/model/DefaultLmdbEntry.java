package org.ametiste.lpp.protocol.lmdb.model;

import org.ametiste.lpp.protocol.lmdb.entry.LmdbEntry;
import org.fusesource.lmdbjni.Entry;

/**
 *
 * @since 0.1.0
 */
public class DefaultLmdbEntry implements LmdbEntry {

    private final String key;
    private final byte[] value;

    /**
     *
     *
     * @param entry
     */
    public DefaultLmdbEntry(Entry entry) {
        notNull(entry, "'entry' must be initialized");

        this.key = new String(entry.getKey());
        this.value = entry.getValue().clone();
    }

    /**
     *
     *
     * @param key
     * @param value
     */
    public DefaultLmdbEntry(String key, byte[] value) {
        notNull(key, "'key' must be initialized");
        notNull(value, "'value' must be initialized");

        this.key = key;
        this.value = value.clone();
    }

    @Override
    public String key() {
        return key;
    }

    @Override
    public byte[] value() {
        return value;
    }

    private static void notNull(Object o, String msg) {
        if (o == null) {
            throw new IllegalArgumentException(msg);
        }
    }
}
