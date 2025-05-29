package com.visualpathit.account.utils;

<<<<<<< HEAD
import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
=======
import java.net.InetSocketAddress;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visualpathit.account.beans.Components;
<<<<<<< HEAD

@Service
public class ElasticsearchUtil {

    private static Components object;

    @Autowired
    public void setComponents(Components object) {
        ElasticsearchUtil.object = object;    	
    }

    public static RestHighLevelClient getRestHighLevelClient() {
        System.out.println("Creating Elasticsearch client...");
        String elasticsearchHost = object.getElasticsearchHost();
        String elasticsearchPort = object.getElasticsearchPort();
        
        System.out.println("Elasticsearch Host: " + elasticsearchHost);
        System.out.println("Elasticsearch Port: " + elasticsearchPort);

        RestHighLevelClient client = null;
        try {
            client = new RestHighLevelClient(
                RestClient.builder(
                    new HttpHost(elasticsearchHost, Integer.parseInt(elasticsearchPort), "http")
                )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }
=======
@Service
public class ElasticsearchUtil {
	
	private static Components object;
    @Autowired
    public void setComponents(Components object){
    	ElasticsearchUtil.object = object;    	
    	
    }
    public static TransportClient trannsportClient() {
    	System.out.println(" elasticsearch client");
    	String elasticsearchHost =object.getElasticsearchHost();
    	String elasticsearchPort =object.getElasticsearchPort(); 
    	String elasticsearchCluster =object.getElasticsearchCluster();
    	String elasticsearchNode =object.getElasticsearchNode();
    	System.out.println(" elasticsearchHost ........"+ elasticsearchHost);
    	System.out.println(" elasticsearchHost ........"+ elasticsearchPort);
    	TransportClient client = null;
    	try {    	
    	Settings settings = Settings.builder()    			
    			.put("cluster.name",elasticsearchCluster)
    			.put("node.name",elasticsearchNode)
    			.build();
    	client = new PreBuiltTransportClient(settings)
                .addTransportAddress(
                new InetSocketTransportAddress(
                		new InetSocketAddress(elasticsearchHost, Integer.parseInt(elasticsearchPort))));

        
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
    	return client;
      }
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
}
