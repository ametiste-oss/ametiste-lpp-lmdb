package org.ametiste.lpp.protocol.lmdb.entry;

/**
 * {@code LmdbEntry} provides interface to get data from LMDB database entry.
 *
 * @see org.ametiste.lpp.protocol.lmdb.LmdbProtocol
 * @see org.ametiste.lpp.protocol.lmdb.iterator.LmdbIterator
 *
 * @since 0.1.0
 */
public interface LmdbEntry {

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
