package org.ametiste.lpp.protocol.lmdb;

import org.ametiste.laplatform.protocol.Protocol;
import org.ametiste.lpp.protocol.lmdb.iterator.LmdbIterator;

import java.nio.file.Path;

/**
 *
 *
 * @since 0.1.0
 */
public interface LmdbProtocol extends Protocol {

    /**
     *
     * @param path
     * @return
     */
    LmdbIterator iterate(Path path) throws LmdbException;

    /**
     *
     * @param path
     * @param key
     * @return
     */
    LmdbIterator seek(Path path, String key) throws LmdbException;
}
