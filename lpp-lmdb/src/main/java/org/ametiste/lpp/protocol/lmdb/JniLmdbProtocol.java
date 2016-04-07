package org.ametiste.lpp.protocol.lmdb;

import org.ametiste.lpp.protocol.lmdb.iterator.LmdbIterator;
import org.ametiste.lpp.protocol.lmdb.iterator.ReadOnlyLmdbIterator;
import org.ametiste.routine.dsl.annotations.LambdaProtocol;

import java.nio.file.Path;
import java.util.function.Supplier;

/**
 * {@code JniLmdbProtocol} is {@link LmdbProtocol} implementation that use Deephacks JNI library for communication
 * with LMDB databases.
 *
 * @since 0.1.0
 */
@LambdaProtocol
public class JniLmdbProtocol implements LmdbProtocol {

    @Override
    public LmdbIterator iterate(Path path) throws LmdbException {
        return checkedCreation(() -> new ReadOnlyLmdbIterator(path.toString(), null));
    }

    @Override
    public LmdbIterator seek(Path path, String key) throws LmdbException {
        return checkedCreation(() -> new ReadOnlyLmdbIterator(path.toString(), key));
    }

    private static <T> T checkedCreation(Supplier<T> supplier) throws LmdbException {
        try {
            return supplier.get();
        } catch (Exception e) {
            throw new LmdbException(e.getLocalizedMessage(), e);
        }
    }
}
