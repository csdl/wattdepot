package org.wattdepot.resource.sensordata;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.wattdepot.client.WattDepotClient;
import org.wattdepot.client.WattDepotClientException;
import org.wattdepot.test.ServerTestHelper;

/**
 * Tests the SensorData resource API at the HTTP level using WattDepotClient.
 * 
 * @author Robert Brewer
 */
public class TestSensorDataResource extends ServerTestHelper {

  /** The hardcoded name for the public Source. Should be replaced when Source creation works. */
  private static final String pubSource = "saunders-hall";

  /**
   * Test that authentication fails without username and password.
   * 
   * @throws WattDepotClientException If problems are encountered
   */
  @Test
  public void testFullIndexPublicWithNoCredentials() throws WattDepotClientException {
    // Shouldn't authenticate with no username or password
    WattDepotClient client = new WattDepotClient(getHostName(), null, null);
    assertTrue("SensorDataIndex for fresh DB contained data", client.getSensorDataIndex(pubSource)
        .getSensorDataRef().isEmpty());
  }

//  /**
//   * Test that authentication works with admin username and password.
//   * 
//   * @throws Exception If problems occur.
//   */
//  @Test
//  public void testAuthenticationWithAdminCredentials() throws Exception {
//    // Should authenticate with admin username and password
//    WattDepotClient client = new WattDepotClient(getHostName(), adminEmail, adminPassword);
//    // System.out.format("admin email: %s, admin password: %s\n", adminEmail, adminPassword);
//    assertTrue("Authentication failed with admin credentials!", client.isAuthenticated());
//  }
//
//  /**
//   * Test that after authentication, can get placeholder User string.
//   * 
//   * @throws Exception If problems occur.
//   */
//  @Test
//  public void testUserResource() throws Exception {
//    // Currently authenticating as admin user
//    WattDepotClient client = new WattDepotClient(getHostName(), adminEmail, adminPassword);
//    assertTrue("User resource returned incorrect string", client.getUserString("foo").equals(
//        "User resource"));
//  }
//
//  /**
//   * Test that without authentication, cannot retrieve user list.
//   * 
//   * @throws WattDepotClientException If there are problems retrieving User list.
//   */
//  @Test(expected = NotAuthorizedException.class)
//  public void testUsersResourceAnonymous() throws WattDepotClientException {
//    WattDepotClient client = new WattDepotClient(getHostName(), null, null);
//    assertTrue("Able to retrieve users list anonymously", client.getUserIndex().getUserRef()
//        .isEmpty());
//  }
//
//  /**
//   * Test that after authentication, can retrieve user list.
//   * 
//   * @throws Exception If problems occur.
//   */
//  @Test
//  public void testUsersResource() throws Exception {
//    // Currently authenticating as admin user
//    WattDepotClient client = new WattDepotClient(getHostName(), adminEmail, adminPassword);
//   assertSame("Fresh DB has more than just admin user", client.getUserIndex().getUserRef().size(),
//        1);
//  }
}
