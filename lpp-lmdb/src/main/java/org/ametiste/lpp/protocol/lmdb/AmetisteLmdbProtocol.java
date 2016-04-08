package org.ametiste.lpp.protocol.lmdb;

import org.ametiste.laplatform.dsl.LambdaProtocol;
import org.ametiste.lib.lmdb.LmdbConnector;
import org.ametiste.lpp.protocol.lmdb.iterator.DatabaseIterator;
import org.ametiste.lpp.protocol.lmdb.iterator.LmdbIteratorAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.Path;
import java.util.function.Supplier;

/**
 * {@code AmetisteLmdbProtocol} is {@link LmdbProtocol} implementation that use  Ametiste LMDB Connector library for
 * communication with LMDB databases.
 *
 * @since 0.1.0
 */
@LambdaProtocol
public class AmetisteLmdbProtocol implements LmdbProtocol {

    @Autowired
    private LmdbConnector connector;

    @Override
    public DatabaseIterator iterate(Path path) throws LmdbException {
        return checkedCreation(() -> new LmdbIteratorAdapter(connector.iterate(path)));
    }

    @Override
    public DatabaseIterator seek(Path path, String key) throws LmdbException {
        return checkedCreation(() -> new LmdbIteratorAdapter(connector.seek(path, key)));
    }

    private static <T> T checkedCreation(Supplier<T> supplier) throws LmdbException {
        try {
            return supplier.get();
        } catch (Exception e) {
            throw new LmdbException(e.getLocalizedMessage(), e);
        }
    }
}
