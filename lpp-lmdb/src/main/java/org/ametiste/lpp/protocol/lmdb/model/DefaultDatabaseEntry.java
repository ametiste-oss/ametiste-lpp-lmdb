package org.ametiste.lpp.protocol.lmdb.model;

import org.ametiste.lib.lmdb.entry.LmdbEntry;
import org.ametiste.lpp.protocol.lmdb.entry.DatabaseEntry;

/**
 * Default implementation of {@link DatabaseEntry}. Its allows create instance directly from {@link LmdbEntry}.
 *
 * @since 0.1.0
 */
public class DefaultDatabaseEntry implements DatabaseEntry {

    private final String key;
    private final byte[] value;

    /**
     * Create new {@code DatabaseEntry} object from {@link LmdbEntry}.
     *
     * @param entry initialized entry from Deephacks library.
     */
    public DefaultDatabaseEntry(LmdbEntry entry) {
        notNull(entry, "'entry' must be initialized");

        this.key = entry.key();
        this.value = entry.value().clone();
    }

    /**
     * Create new {@code DatabaseEntry} object from raw data.
     *
     * @param key valid string.
     * @param value initialized array.
     */
    public DefaultDatabaseEntry(String key, byte[] value) {
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
