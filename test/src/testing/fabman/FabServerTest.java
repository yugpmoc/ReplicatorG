package testing.fabman;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import fabman.queue.FabServer;

public class FabServerTest {

	@Test
	public void createTestServer() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		FabServer server = new FabServer("");
		URI serverUri = server.getServerURI();
		assert serverUri != null;
		assert "localhost".equals(serverUri.getHost());
		assert serverUri.getPort() > 0;
		assert "fab".equals(serverUri.getScheme());
	}
	
	@Test
	public void createTestServerProcess() throws IOException, URISyntaxException {
		URI serverUri = FabServer.startServer("");
		assert serverUri != null;
		assert "localhost".equals(serverUri.getHost());
		assert serverUri.getPort() > 0;
		assert "fab".equals(serverUri.getScheme());
	}
}