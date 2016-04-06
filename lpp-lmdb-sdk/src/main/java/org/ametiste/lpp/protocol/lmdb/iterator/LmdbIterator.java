package org.ametiste.lpp.protocol.lmdb.iterator;

import org.ametiste.lpp.protocol.lmdb.entry.LmdbEntry;

import java.util.Iterator;

/**
 *
 *
 * @since 0.1.0
 */
public interface LmdbIterator extends Iterator<LmdbEntry>, AutoCloseable {

}
