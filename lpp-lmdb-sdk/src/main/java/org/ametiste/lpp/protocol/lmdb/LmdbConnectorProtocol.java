package org.ametiste.lpp.protocol.lmdb;

import org.ametiste.laplatform.sdk.protocol.Protocol;
import org.ametiste.lib.lmdb.LmdbConnector;

/**
 * {@code LmdbConnectorProtocol} is a lambda platform protocol that provide interface to process LMDB databases.
 * <p>
 * Protocol extends {@link LmdbConnector} from LMDB Library API.
 *
 * @see LmdbConnector
 *
 * @since 0.1.0
 */
public interface LmdbConnectorProtocol extends LmdbConnector, Protocol {

}
