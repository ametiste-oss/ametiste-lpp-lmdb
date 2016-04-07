package org.ametiste.lpp.protocol.lmdb.model;

import org.ametiste.lpp.protocol.lmdb.entry.LmdbEntry;
import org.fusesource.lmdbjni.Entry;

/**
 * Default implementation of {@link LmdbEntry}.
 *
 * @since 0.1.0
 */
public class DefaultLmdbEntry implements LmdbEntry {

    private final String key;
    private final byte[] value;

    /**
     * Create new {@code LmdbEntry} object from {@link Entry}.
     *
     * @param entry initialized entry from Deephacks library.
     */
    public DefaultLmdbEntry(Entry entry) {
        notNull(entry, "'entry' must be initialized");

        this.key = new String(entry.getKey());
        this.value = entry.getValue().clone();
    }

    /**
     * Create new {@code LmdbEntry} object from raw data.
     *
     * @param key valid string.
     * @param value initialized array.
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
