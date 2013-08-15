package org.wattdepot.resource.health;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.wattdepot.client.WattDepotClient;
import org.wattdepot.test.ServerTestHelper;

/**
 * Tests the Ping API, which is very simple.
 * 
 * @author Robert Brewer
 */
public class TestHealthResource extends ServerTestHelper {

  /**
   * Test whether the Health resource is working, both with proper status code, and health text.
   * 
   * @throws Exception If problems occur.
   */
  @Test
  public void testResource() throws Exception {
    WattDepotClient client = new WattDepotClient(getHostName());
    assertTrue("Server is unhealthy", client.isHealthy());
    System.out.println(client.getHealthString());
    assertTrue("Unexpected server message",
        client.getHealthString().equals(HealthResource.WATTDEPOT_MESSAGE_TEXT +
            getClass().getPackage().getImplementationVersion() + 
            HealthResource.HEALTH_MESSAGE_TEXT));
  }
}
