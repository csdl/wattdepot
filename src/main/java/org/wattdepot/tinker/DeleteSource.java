package org.wattdepot.tinker;

import org.wattdepot.client.WattDepotClient;
import org.wattdepot.resource.source.summary.jaxb.SourceSummary;

public class DeleteSource {

  public static String hostUri;
  public static String username;
  public static String password;
  public static String source;

  /**
   * @param args
   * @throws Exception If things go wrong
   */
  public static void main(String[] args) throws Exception {
    hostUri = args[0];
    username = args[1];
    password = args[2];
    source = args[3];
    WattDepotClient client = new WattDepotClient(hostUri, username, password);

    SourceSummary summary = client.getSourceSummary(source);
    System.out.println(summary);

    client.deleteSource(source);

    summary = client.getSourceSummary(source);
    System.out.println(summary);
  }
}
