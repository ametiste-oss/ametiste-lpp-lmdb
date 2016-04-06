package org.ametiste.lpp.protocol.lmdb.iterator;

import org.ametiste.lpp.protocol.lmdb.model.DefaultLmdbEntry;
import org.fusesource.lmdbjni.*;

import java.util.Optional;

public class ReadOnlyLmdbIterator implements LmdbIterator {

    private final Env env;
    private final Database db;
    private final EntryIterator iter;

    /**
     *
     *
     * @param path
     * @param key
     */
    public ReadOnlyLmdbIterator(String path, String key) {
        if (path == null) {
            throw new IllegalArgumentException("'env' must be initialized");
        }
        this.env = new Env(path);

        Transaction tx = env.createReadTransaction();
        this.db = env.openDatabase();

        this.iter = key == null ? db.iterate(tx) : db.seek(tx, key.getBytes());
    }

    @Override
    public void close() throws Exception {
        iter.close();
        db.close();
        env.close();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public DefaultLmdbEntry next() {
        Entry entry = iter.next();
        return new DefaultLmdbEntry(new String(entry.getKey()), entry.getValue());
    }
}
