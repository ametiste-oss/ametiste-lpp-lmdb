package org.ametiste.lpp.protocol.lmdb.entry;

/**
 *
 * @since 0.1.0
 */
public interface LmdbEntry {

    /**
     *
     * @return
     */
    String key();

    /**
     *
     * @return
     */
    byte[] value();
}
