package org.ametiste.lpp.protocol.lmdb;

import org.ametiste.laplatform.protocol.ProtocolGateway;
import org.ametiste.lpp.protocol.lmdb.iterator.LmdbIterator;

import java.nio.file.Path;

/**
 * {@code LmdbProtocolClient} is {@link LmdbProtocol} implementation that encapsulate mechanism of
 * communication with {@link ProtocolGateway} and provide more clear way to use protocol.
 *
 * @since 0.1.0
 */
public class LmdbProtocolClient implements LmdbProtocol {

    private final ProtocolGateway gateway;

    /**
     * Create new instance of {@code LmdbProtocolClient}.
     *
     * @param gateway {@code ProtocolGateway} instance that provides session to {@code LmdbProtocol} implementation.
     *                Must not be {@code null}.
     */
    public LmdbProtocolClient(ProtocolGateway gateway) {
        if (gateway == null) {
            throw new IllegalArgumentException("protocol gateway must be initialized.");
        }
        this.gateway = gateway;
    }

    @Override
    public LmdbIterator iterate(Path path) throws LmdbException {
        return gateway.session(LmdbProtocol.class).iterate(path);
    }

    @Override
    public LmdbIterator seek(Path path, String key) throws LmdbException {
        return gateway.session(LmdbProtocol.class).seek(path, key);
    }
}