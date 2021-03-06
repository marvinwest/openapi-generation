package generated.server;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Assertions;

public class ResponseVerifier {
	
	public void verifyNotImplemented(Response response) {
		this.verifyStatus(response, Response.Status.NOT_IMPLEMENTED);
	}
	
	public void verifyClientError(Response response) {
		Assertions.assertEquals(Response.Status.Family.CLIENT_ERROR, response.getStatusInfo().getFamily());
	}

    public void verifyStatus(Response response, Response.Status clientStatus) {
        final var status = response.getStatus();
        response.close();

        Assertions.assertEquals(clientStatus.getStatusCode(), status);
    }
    
}
