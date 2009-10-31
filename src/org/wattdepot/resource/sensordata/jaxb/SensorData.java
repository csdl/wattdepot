//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.08.17 at 01:54:50 PM HST 
//

package org.wattdepot.resource.sensordata.jaxb;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.wattdepot.resource.property.jaxb.Properties;
import org.wattdepot.resource.property.jaxb.Property;
import org.wattdepot.resource.source.jaxb.Source;
import org.wattdepot.server.Server;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}Timestamp"/>
 *         &lt;element ref="{}Tool"/>
 *         &lt;element ref="{}Source"/>
 *         &lt;element ref="{}Properties" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "timestamp", "tool", "source", "properties" })
@XmlRootElement(name = "SensorData")
public class SensorData implements Serializable {

  private final static long serialVersionUID = 12343L;
  @XmlElement(name = "Timestamp", required = true)
  @XmlSchemaType(name = "dateTime")
  protected XMLGregorianCalendar timestamp;
  @XmlElement(name = "Tool", required = true)
  protected String tool;
  @XmlElement(name = "Source", required = true)
  @XmlSchemaType(name = "anyURI")
  protected String source;
  @XmlElement(name = "Properties")
  protected Properties properties;

  public static final String POWER_CONSUMED = "powerConsumed";
  public static final String POWER_GENERATED = "powerGenerated";
  public static final String ENERGY_CONSUMED = "energyConsumed";
  public static final String ENERGY_GENERATED = "energyGenerated";
  public static final String ENERGY_CONSUMED_TO_DATE = "energyConsumedToDate";
  public static final String ENERGY_GENERATED_TO_DATE = "energyGeneratedToDate";
  public static final String CARBON_EMITTED = "carbonEmitted";
  public static final String INTERPOLATED = "interpolated";
  public static final Property interpolatedProperty = new Property(INTERPOLATED, "true");

  /**
   * Default no-argument constructor, apparently needed by JAXB. Don't use this, use the one with
   * all the parameters.
   */
  public SensorData() {
    // Apparently needed by JAXB
  }

  /**
   * Returns a new SensorData object with the provided parameters. Needs to be kept up to date with
   * any changes to the schema, which is bogus.
   * 
   * @param timestamp The timestamp for the SensorData.
   * @param tool The tool used to create the SensorData.
   * @param source The URI of the Source this SensorData belongs to.
   * @param props The properties for the SensorData.
   */
  public SensorData(XMLGregorianCalendar timestamp, String tool, String source, Properties props) {
    this.timestamp = timestamp;
    this.tool = tool;
    this.source = source;
    this.properties = props;
  }

  /**
   * Convenience constructor for SensorData that takes a single Property, instead of a Properties
   * object. Useful when creating a SensorData that only has a single property. Needs to be kept up
   * to date with any changes to the schema, which is bogus.
   * 
   * @param timestamp The timestamp for the SensorData.
   * @param tool The tool used to create the SensorData.
   * @param source The URI of the Source this SensorData belongs to.
   * @param prop The Property for the SensorData.
   */
  public SensorData(XMLGregorianCalendar timestamp, String tool, String source, Property prop) {
    this(timestamp, tool, source);
    this.properties = new Properties();
    this.properties.getProperty().add(prop);
  }

  /**
   * Convenience constructor for SensorData without Properties object. Useful when creating a
   * SensorData that has no properties. Needs to be kept up to date with any changes to the schema,
   * which is bogus.
   * 
   * @param timestamp The timestamp for the SensorData.
   * @param tool The tool used to create the SensorData.
   * @param source The URI of the Source this SensorData belongs to.
   */
  public SensorData(XMLGregorianCalendar timestamp, String tool, String source) {
    this(timestamp, tool, source, (Properties) null);
  }

  /**
   * Gets the value of the timestamp property.
   * 
   * @return possible object is {@link XMLGregorianCalendar }
   * 
   */
  public XMLGregorianCalendar getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the value of the timestamp property.
   * 
   * @param value allowed object is {@link XMLGregorianCalendar }
   * 
   */
  public void setTimestamp(XMLGregorianCalendar value) {
    this.timestamp = value;
  }

  public boolean isSetTimestamp() {
    return (this.timestamp != null);
  }

  /**
   * Gets the value of the tool property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getTool() {
    return tool;
  }

  /**
   * Sets the value of the tool property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setTool(String value) {
    this.tool = value;
  }

  public boolean isSetTool() {
    return (this.tool != null);
  }

  /**
   * Gets the value of the source property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getSource() {
    return source;
  }

  /**
   * Sets the value of the source property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setSource(String value) {
    this.source = value;
  }

  public boolean isSetSource() {
    return (this.source != null);
  }

  /**
   * Gets the value of the properties property.
   * 
   * @return possible object is {@link Properties }
   * 
   */
  public Properties getProperties() {
    return properties;
  }

  /**
   * Sets the value of the properties property.
   * 
   * @param value allowed object is {@link Properties }
   * 
   */
  public void setProperties(Properties value) {
    this.properties = value;
  }

  public boolean isSetProperties() {
    return (this.properties != null);
  }

  // Broke down and added these manually to the generated code. It would be better if they were
  // automatically generated via XJC plugins, but that required a bunch of dependencies that I
  // was unwilling to deal with right now. If the schema files change, this code will be blown
  // away, so there are unit tests that confirm that equals and hashCode work to guard against
  // that.

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((properties == null) ? 0 : properties.hashCode());
    result = prime * result + ((source == null) ? 0 : source.hashCode());
    result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
    result = prime * result + ((tool == null) ? 0 : tool.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    SensorData other = (SensorData) obj;
    if (properties == null) {
      if (other.properties != null) {
        return false;
      }
    }
    else if (!properties.equals(other.properties)) {
      return false;
    }
    if (source == null) {
      if (other.source != null) {
        return false;
      }
    }
    else if (!source.equals(other.source)) {
      return false;
    }
    if (timestamp == null) {
      if (other.timestamp != null) {
        return false;
      }
    }
    else if (!timestamp.equals(other.timestamp)) {
      return false;
    }
    if (tool == null) {
      if (other.tool != null) {
        return false;
      }
    }
    else if (!tool.equals(other.tool)) {
      return false;
    }
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "SensorData [properties=" + properties + ", source=" + source + ", timestamp="
        + timestamp + ", tool=" + tool + "]";
  }

  /**
   * A convenience method to add a Property to the List of Property stored in the Properties field.
   * 
   * @param prop The Property to add.
   */
  public void addProperty(Property prop) {
    if (this.properties == null) {
      this.properties = new Properties();
    }
    this.properties.getProperty().add(prop);
  }

  /**
   * Returns the value of the Property with the given key as a double. If the key is not found, it
   * returns 0. Only the first property with the given key is returned. This is a convenience method
   * that calls the underlying Properties method.
   * 
   * @param key The key.
   * @return The key's value as a double.
   */
  public double getPropertyAsDouble(String key) {
    return this.properties.getPropertyAsDouble(key);
  }

  /**
   * Returns the value of the Property with the given key as a String. If the key is not found, it
   * returns null. Only the first property with the given key is returned. This is a convenience
   * method that calls the underlying Properties method.
   * 
   * @param key The key.
   * @return The key's value as a double.
   */
  public String getProperty(String key) {
    return this.properties.getProperty(key);
  }

  /**
   * Returns true if this Properties contains the given Property, or false otherwise. Convenience
   * method that calls Properties.containsProperty().
   * 
   * @param prop The property to be searched for.
   * @return True if prop is found, false otherwise.
   */
  public boolean containsProperty(Property prop) {
    return this.properties.containsProperty(prop);
  }

  /**
   * Tests whether this SensorData was created through interpolation.
   * 
   * @return True if this SensorData was interpolated, false otherwise.
   */
  public boolean isInterpolated() {
    return containsProperty(interpolatedProperty);
  }

  /**
   * Sets the interpolated property to the desired value. To indicate that the SensorData is
   * interpolated, the property SensorData.INTERPOLATED is set to value "true". To indicate that
   * the SensorData is not interpolated, the property is deleted.
   * 
   * @param interpolatedp The interpolated value to set.
   */
  public void setInterpolated(boolean interpolatedp) {
    if (interpolatedp) {
      addProperty(interpolatedProperty);
    }
    else {
      this.properties.getProperty().remove(interpolatedProperty);
    }
  }

  /**
   * Given the Server and Source a SensorData object belongs to, returns the URI to that SensorData
   * resource.
   * 
   * @param source The Source the SensorData belongs to.
   * @param server The Server user belongs to.
   * @return The URI to the SensorData resource corresponding to the given SensorData object.
   */
  public String toUri(Source source, Server server) {
    return server.getHostName() + Server.SOURCES_URI + "/" + source.getName() + "/"
        + Server.SENSORDATA_URI + this.timestamp.toXMLFormat();
  }
}
