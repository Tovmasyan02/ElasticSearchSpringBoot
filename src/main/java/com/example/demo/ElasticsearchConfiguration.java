package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories()
public class ElasticsearchConfiguration {


    @Bean
    public Client client() throws UnknownHostException {
    	
    	 Settings esSettings = Settings.builder()
                 .put("cluster.name", "mycluster")
                 //.put("node.name","4ca16122605d")
                 .build();
    	 
    	@SuppressWarnings("resource")
		TransportClient client = new PreBuiltTransportClient(esSettings)
    	        .addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.99.100"), 9300));
    return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws UnknownHostException {
        return new ElasticsearchTemplate(client());
    }
}