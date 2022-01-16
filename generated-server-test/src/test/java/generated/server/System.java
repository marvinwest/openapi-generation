package generated.server;

import java.io.Closeable;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient43Engine;

public abstract class System implements Closeable {

	private final ResponseVerifier verifier = new ResponseVerifier();
	
	private Client client;
	private WebTarget origin;
	
	public WebTarget fetchOrigin() {
        if (this.origin == null) {
            this.initializeConnectionLazily();
        }

        return this.origin;
    }
	
	private void initializeConnectionLazily() {
        final var connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(20);
        connectionManager.setDefaultMaxPerRoute(20);

        final var reqConfig = RequestConfig.custom()
                .build();

        final var httpClient = HttpClients.custom()
                .setDefaultRequestConfig(reqConfig)
                .setConnectionManager(connectionManager)
                .build();
        final var httpEngine = new ApacheHttpClient43Engine(httpClient);
        httpEngine.setFollowRedirects(true);

        this.client = ((ResteasyClientBuilder) ClientBuilder.newBuilder())
                .httpEngine(httpEngine)
                .register(new JacksonContextResolver())
                .build();

        this.origin = this.client.target("http://localhost:8080/");
    }
	
    public ResponseVerifier getVerifier() {
        return verifier;
    }
    
    @Override
    public void close() {
        if (this.client != null) {
            this.client.close();
        }
    }
}
