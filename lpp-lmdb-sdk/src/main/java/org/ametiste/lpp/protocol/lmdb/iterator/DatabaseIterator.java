package org.ametiste.lpp.protocol.lmdb.iterator;

import org.ametiste.lpp.protocol.lmdb.entry.DatabaseEntry;

import java.util.Iterator;

/**
 * Iterator over LMDB database data.
 * <p>
 * {@code DatabaseIterator} implements {@link AutoCloseable} interface and may be used in java try-with-resources statement or
 * must be closed manually.
 *
 * @see DatabaseEntry
 *
 * @since 0.1.0
 */
public interface DatabaseIterator extends Iterator<DatabaseEntry>, AutoCloseable {

}
