package org.jboss.qa.examples.bpm_taxi.util;

import org.jboss.qa.examples.bpm_taxi.Registry;

public class RegistryDataGenerator {

    public Registry generateRegistry() {
        Registry registry = new Registry();
        registry.setAddresses(Addresses.getAllAddresses());
        registry.setTaxis(Taxis.getAllTaxis());
        registry.setCustomers(Customers.getAllCustomers());

        return registry;
    }
}
