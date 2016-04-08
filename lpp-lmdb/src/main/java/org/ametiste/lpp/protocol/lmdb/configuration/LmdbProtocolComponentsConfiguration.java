package org.ametiste.lpp.protocol.lmdb.configuration;

import org.ametiste.lib.lmdb.JniLmdbConnector;
import org.ametiste.lib.lmdb.LmdbConnector;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration provides components required for {@code LmdbConnectorProtocol} operations.
 *
 * @since 0.1.0
 */
@Configuration
public class LmdbProtocolComponentsConfiguration {

    @Bean
    @ConditionalOnMissingBean(LmdbConnector.class)
    public LmdbConnector jniLmdbConnector() {
        return new JniLmdbConnector();
    }
}
