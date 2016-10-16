package org.jboss.qa.examples.bpm_taxi;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "addresses",
        "taxis",
        "customers"
})
public class Registry implements java.io.Serializable {

    @XmlElementWrapper
    private Collection<Address> addresses;

    @XmlElementWrapper
    private Collection<Taxi> taxis;

    @XmlElementWrapper
    private Collection<Customer> customers;

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(final Collection<Address> addresses) {
        this.addresses = addresses;
    }

    public Collection<Taxi> getTaxis() {
        return taxis;
    }

    public void setTaxis(final Collection<Taxi> taxis) {
        this.taxis = taxis;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(final Collection<Customer> customers) {
        this.customers = customers;
    }
}
