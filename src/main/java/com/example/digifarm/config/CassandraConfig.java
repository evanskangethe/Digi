package com.example.digifarm.config;

import com.datastax.driver.core.Cluster;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.SessionFactory;
import org.springframework.data.cassandra.config.*;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.SimpleUserTypeResolver;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.example.digifarm")
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${spring.data.cassandra.keyspace-name}")
    private String KEYSPACE;

    @Bean
    @Override
    public CassandraSessionFactoryBean session() {

        Cluster cluster = Cluster.builder()
                .withoutJMXReporting()
                .addContactPoint("127.0.0.1")
                .build();

        CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();

        session.setCluster(cluster);
        session.setConverter(cassandraConverter());
        session.setKeyspaceName(getKeyspaceName());
        session.setSchemaAction(getSchemaAction());
        session.setStartupScripts(getStartupScripts());
        session.setShutdownScripts(getShutdownScripts());
        return session;
    }

    @Override
    protected String getKeyspaceName() {
        return KEYSPACE;
    }

    @Override
    public CassandraClusterFactoryBean cluster() {
        return super.cluster();
    }

    @Override
    public CassandraMappingContext cassandraMapping() {
        CassandraMappingContext mappingContext = new CassandraMappingContext();
        mappingContext.setUserTypeResolver(new SimpleUserTypeResolver(cluster().getObject(), getKeyspaceName()));
        return mappingContext;
    }

    @Bean
    public CassandraConverter converter() {
        return new MappingCassandraConverter(cassandraMapping());
    }
}