package org.ametiste.lpp.protocol.lmdb.entry;

import org.ametiste.lpp.protocol.lmdb.iterator.DatabaseIterator;

/**
 * {@code DatabaseEntry} provides interface to get data from LMDB database entry.
 *
 * @see org.ametiste.lpp.protocol.lmdb.LmdbProtocol
 * @see DatabaseIterator
 *
 * @since 0.1.0
 */
public interface DatabaseEntry {

    /**
     * Get entry key.
     *
     * @return not empty string.
     */
    String key();

    /**
     * Get entry value.
     *
     * @return initialized byte array.
     */
    byte[] value();
}
