package org.ametiste.lpp.protocol.lmdb;

/**
 * Signals about any error occurred during operation with LMDB (incorrect source, inappropriate usage, etc.)
 *
 * @see LmdbProtocol
 *
 * @since 0.1.0
 */
public class LmdbException extends RuntimeException {

    public LmdbException(String message) {
        super(message);
    }

    public LmdbException(String message, Throwable cause) {
        super(message, cause);
    }
}
