package org.ametiste.lpp.protocol.lmdb;

import org.ametiste.laplatform.sdk.protocol.Protocol;
import org.ametiste.lpp.protocol.lmdb.iterator.DatabaseIterator;

import java.nio.file.Path;

/**
 * {@code LmdbProtocol} is a lambda platform protocol that provide interface to process LMDB databases.
 * <p>
 * Protocol implementations return {@link AutoCloseable} objects that must be closed after processing.
 *
 * @see DatabaseIterator
 *
 * @since 0.1.0
 */
public interface LmdbProtocol extends Protocol {

    /**
     * Get database iterator that starts from begging.
     *
     * @param path lmdb database path. Must be valid directory.
     *
     * @return {@link DatabaseIterator} instance.
     */
    DatabaseIterator iterate(Path path) throws LmdbException;

    /**
     * Get database iterator that starts from provided key.
     *
     * @param path lmdb database path. Must be valid directory.
     * @param key start point (database key) for iteration.
     *
     * @return {@link DatabaseIterator} instance.
     */
    DatabaseIterator seek(Path path, String key) throws LmdbException;
}
