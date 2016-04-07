package org.ametiste.lpp.protocol.lmdb.iterator;

import org.ametiste.lib.lmdb.iterator.LmdbIterator;
import org.ametiste.lpp.protocol.lmdb.entry.DatabaseEntry;
import org.ametiste.lpp.protocol.lmdb.model.DefaultDatabaseEntry;

/**
 * {@link DatabaseIterator} implementation that is adapter for {@link LmdbIterator} interface.
 * <p>
 * After all operation {@link #close()} method must be called.
 *
 * @since 0.1.0
 */
public class LmdbIteratorAdapter implements DatabaseIterator {

    private final LmdbIterator iterator;

    public LmdbIteratorAdapter(LmdbIterator iterator) {
        if (iterator == null) {
            throw new IllegalArgumentException("'iterator' must be initialized");
        }
        this.iterator = iterator;
    }


    @Override
    public void close() throws Exception {
        iterator.close();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public DatabaseEntry next() {
        return new DefaultDatabaseEntry(iterator.next());
    }
}
