package org.jboss.qa.examples.bpm_taxi;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "addresses",
        "taxis"
})
public class Registry {

    @XmlElementWrapper
    private List<Address> addresses;

    @XmlElementWrapper
    private List<Taxi> taxis;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(final List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Taxi> getTaxis() {
        return taxis;
    }

    public void setTaxis(final List<Taxi> taxis) {
        this.taxis = taxis;
    }
}
