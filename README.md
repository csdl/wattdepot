<img src="https://code.google.com/p/wattdepot/logo?cct=1372391872" alt="Logo" itemprop="image">
 
WattDepot
=========
<h2><a name="Overview"></a>Overview<a href="#Overview" class="section_anchor"></a></h2><p>WattDepot is an open source, RESTful web service that collects electricity data (such as current power utilization or cumulative power utilization) from meters and stores it in a database. The data can then be retrieved by other tools for visualization and analysis.  It is designed to provide infrastructure for experimentation and development of &quot;Smart Grid&quot; applications.  </p><p>WattDepot provides a unique combination of useful features: </p><ul><li>WattDepot is agnostic about the kinds of meters used to monitor energy production/consumption data, and whether the energy data is utility-scale or personal-scale.  WattDepot implements a <a href="http://en.wikipedia.org/wiki/Representational_State_Transfer" rel="nofollow">REST</a> protocol for data transmission that can be used to implement clients for a wide variety of devices; the major constraint is that these devices need to have Internet access.  WattDepot clients can be written in any language that supports the HTTP protocol. We provide a high-level client library for Java.  </li></ul><ul><li>WattDepot can represent aggregations of power sources.  For example, a building might have multiple meters monitoring energy consumption, one per floor.  WattDepot can represent the power consumed by individual floors, as well as an aggregate source representing the building as a whole.  Aggregations can be nested, so that floors can be aggregated into buildings, buildings into neighborhoods, and neighborhoods into cities.  </li></ul><ul><li>WattDepot automatically performs data interpolation when necessary.  For example, a meter might provide a snapshot of energy usage once per hour for a given device. Clients can request the power consumed by this device at any time instant, and WattDepot will automatically provide interpolation when the requested time does not match a time for which actual sensor data is available.  This becomes particularly important and useful for aggregate power sources. For example, the meters on individual floors of a building will rarely send their data at exactly the same time instant, so providing an aggregate value for power consumed requires combining individual data values obtained at different times.  </li></ul><ul><li>WattDepot can support carbon intensity data as well as energy data.  To understand the ecological impact of power, it is useful to know the amount of carbon released by a given energy generation source.   </li></ul><ul><li>WattDepot is architecturally decoupled from the underlying data storage technology. This supports experimentation with both traditional relational as well as <a href="http://en.wikipedia.org/wiki/Nosql" rel="nofollow">NoSQL</a> technologies, and facilitates scalability.  Currently, WattDepot implements support for <a href="http://db.apache.org/derby/" rel="nofollow">Derby</a>, <a href="http://www.postgresql.org/" rel="nofollow">Postgres</a>, and <a href="http://www.oracle.com/technetwork/products/berkeleydb/overview/index.html" rel="nofollow">BerkeleyDB</a> storage systems. </li></ul><ul><li>WattDepot is designed to support both PaaS and local installation.  We have deployed WattDepot to the <a href="http://heroku.com" rel="nofollow">Heroku</a> cloud-based hosting service.  </li></ul><ul><li>WattDepot implements support for &quot;ephemeral&quot; data.  In some application scenarios, it is useful to send energy data to the WattDepot server quite frequently (i.e. every few seconds) so that clients can monitor current energy consumption with low latency.  However, that rate of data sampling is not necessary for historical analyses, which may only require energy data sampling at the rate of every few minutes.   WattDepot supports this situation through &quot;ephemeral&quot; data, which creates an in-memory &quot;window&quot; during which all recently received energy data is available for retrieval, but stored in the repository only at a much lower sampling rate.  This can reduce the size of the repository by one or more orders of magnitude while retaining the benefits of high sampling rate for recent data.  </li></ul><ul><li>WattDepot is open source and will remain freely available to the community. </li></ul><h2><a name="Publications"></a>Publications<a href="#Publications" class="section_anchor"></a></h2><p>Selected publications and technical reports regarding WattDepot and the systems built using it are available  <a href="http://www.citeulike.org/group/3370/tag/wattdepot" rel="nofollow">here</a>. </p><h2><a name="Associated_tools"></a>Associated tools<a href="#Associated_tools" class="section_anchor"></a></h2><p>WattDepot provides the architectural center of an ecosystem of tools for energy data collection,  storage, analysis, and presentation. Some associated technology now under development includes: </p><p><table class="wikitable"><tr><td style="border: 1px solid #ccc; padding: 5px;"> <a href="http://code.google.com/p/wattdepot-sensor-modbus/" rel="nofollow">WattDepot ModBus Sensor</a></td><td style="border: 1px solid #ccc; padding: 5px;"> Provides support for polling energy meters through the ModBus protocol to collect energy data for storage in WattDepot. </td></tr> <tr><td style="border: 1px solid #ccc; padding: 5px;"> <a href="http://code.google.com/p/wattdepot-apps/" rel="nofollow">WattDepot Apps</a> </td><td style="border: 1px solid #ccc; padding: 5px;"> Provides a web application for basic display of energy data. </td></tr> <tr><td style="border: 1px solid #ccc; padding: 5px;"> <a href="http://code.google.com/p/wattdepot-cli/" rel="nofollow">WattDepot CLI</a> </td><td style="border: 1px solid #ccc; padding: 5px;"> Provides a command line interface for inspecting the contents of the service. </td></tr> <tr><td style="border: 1px solid #ccc; padding: 5px;"> <a href="http://code.google.com/p/wattdepot-ui-googlegadgets/" rel="nofollow">WattDepot Gadgets</a> </td><td style="border: 1px solid #ccc; padding: 5px;"> Provides a selection of google gadget visualizations for WattDepot. </td></tr> <tr><td style="border: 1px solid #ccc; padding: 5px;"> <a href="http://code.google.com/p/wattdepot-simulation/" rel="nofollow">WattDepot Simulations</a> </td><td style="border: 1px solid #ccc; padding: 5px;"> Provides simulated data to support evaluation of WattDepot visualization and analysis services. </td></tr> <tr><td style="border: 1px solid #ccc; padding: 5px;"> <a href="http://wiki.github.com/remyb/WattDroid/" rel="nofollow">WattDroid</a> </td><td style="border: 1px solid #ccc; padding: 5px;"> An Android interface to WattDepot sources. </td></tr> <tr><td style="border: 1px solid #ccc; padding: 5px;"> <a href="http://code.google.com/p/wattdepot-gdata/" rel="nofollow">WattDepot-GData</a> </td><td style="border: 1px solid #ccc; padding: 5px;"> Provides a persistent cache for WattDepot data using Google Docs. </td></tr> <tr><td style="border: 1px solid #ccc; padding: 5px;"> <a href="http://code.google.com/p/wattdepot-javascript-client/" rel="nofollow">WattDepot-Javascript-Client</a> </td><td style="border: 1px solid #ccc; padding: 5px;"> Provides a Javascript client for WattDepot. </td></tr> </table></p><h2><a name="Public_server"></a>Public server<a href="#Public_server" class="section_anchor"></a></h2><p>While you can download and run your own instance of WattDepot, the <a href="http://csdl.ics.hawaii.edu" rel="nofollow">Collaborative Software Development Laboratory</a> in the <a href="http://www.ics.hawaii.edu" rel="nofollow">Department of Computer and Information Sciences</a> at the <a href="http://www.hawaii.edu" rel="nofollow">University of Hawaii</a> supports a public instance of WattDepot: </p><p><table class="wikitable"><tr><td style="border: 1px solid #ccc; padding: 5px;"> REST &amp; Data source API URI: </td><td style="border: 1px solid #ccc; padding: 5px;"> <a href="http://server.wattdepot.org:8194/wattdepot/" rel="nofollow">http://server.wattdepot.org:8194/wattdepot/</a> </td></tr> <tr><td style="border: 1px solid #ccc; padding: 5px;"> Visualizer and monitor: </td><td style="border: 1px solid #ccc; padding: 5px;"> <a href="http://server.wattdepot.org:8006/wattdepotapps/" rel="nofollow">http://server.wattdepot.org:8006/wattdepotapps/</a> </td></tr> </table></p><p>Note: this server is running a beta version of WattDepot and not all historical energy data from 2011 has been transferred to it. </p><p>We invite you to become involved with the system. Please peruse our <a href="http://code.google.com/p/wattdepot/w/list" rel="nofollow">Wiki pages</a> or join our <a href="http://groups.google.com/group/wattdepot-users" rel="nofollow">mailing list</a>.  </p><p>  </p>
 </td>
 </tr>
</table>
