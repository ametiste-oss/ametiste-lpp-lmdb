package org.ametiste.lpp.protocol.lmdb;

import org.ametiste.laplatform.dsl.LambdaProtocol;
import org.ametiste.laplatform.dsl.ProtocolMeta;
import org.ametiste.lib.lmdb.LmdbConnector;
import org.ametiste.lib.lmdb.LmdbConnectorException;
import org.ametiste.lib.lmdb.iterator.LmdbIterator;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.Path;

/**
 * {@code DefaultLmdbConnectorProtocol} is {@link LmdbConnectorProtocol} implementation that connects
 * Ametiste LMDB library with L-Platform for communication with LMDB databases.
 *
 * @since 0.1.0
 */
@LambdaProtocol
@ProtocolMeta(shortName = "lmdb-connector")
public class DefaultLmdbConnectorProtocol implements LmdbConnectorProtocol {

    @Autowired
    private LmdbConnector connector;


    @Override
    public LmdbIterator iterate(Path path) throws LmdbConnectorException {
        return connector.iterate(path);
    }

    @Override
    public LmdbIterator seek(Path path, String key) throws LmdbConnectorException {
        return connector.seek(path, key);
    }
}
