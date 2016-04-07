package org.ametiste.lpp.protocol.lmdb.iterator;

import org.ametiste.lpp.protocol.lmdb.entry.LmdbEntry;

import java.util.Iterator;

/**
 * Iterator over LMDB database data.
 * <p>
 * {@code LmdbIterator} imlepents {@link AutoCloseable} interface and may be used in java try-with-resources statement or
 * must be closed manually.
 *
 * @see LmdbEntry
 *
 * @since 0.1.0
 */
public interface LmdbIterator extends Iterator<LmdbEntry>, AutoCloseable {

}
