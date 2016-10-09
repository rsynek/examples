package org.jboss.qa.examples.bpm_taxi.util;

import java.util.ArrayList;
import java.util.List;
import org.jboss.qa.examples.bpm_taxi.Address;
import org.jboss.qa.examples.bpm_taxi.Location;
import org.jboss.qa.examples.bpm_taxi.Registry;
import org.jboss.qa.examples.bpm_taxi.Taxi;

public class RegistryDataGenerator {

    public List<Address> generateAddresses() {
        List<Address> addresses = new ArrayList<>();

        addresses.add(generateAddressPekarska());
        addresses.add(generateAddressCernopolni());
        addresses.add(generateAddressNovolisenska());
        addresses.add(generateAddressKurim());

        return addresses;
    }

    public List<Taxi> generateTaxis() {
        List<Taxi> taxis = new ArrayList<>();

        taxis.add(new Taxi(generateAddressNovolisenska(), "1B35623"));
        taxis.add(new Taxi(generateAddressCernopolni(), "1B59683"));
        taxis.add(new Taxi(generateAddressKurim(), "1B86614"));

        return taxis;
    }

    public Registry generateRegistry() {
        Registry registry = new Registry();
        registry.setAddresses(generateAddresses());
        registry.setTaxis(generateTaxis());

        return registry;
    }

    private Address generateAddressPekarska() {
        return new Address("Brno", "Pekarska 26", new Location(49.192396, 16.601537));
    }

    private Address generateAddressCernopolni() {
        return new Address("Brno", "Cernopolni 45", new Location(49.207388, 16.616178));
    }

    private Address generateAddressNovolisenska() {
        return new Address("Brno", "Novolisenska 2702", new Location(49.213878, 16.683052));
    }

    private Address generateAddressKurim() {
        return new Address("Kurim", "Jungmannova 906", new Location(49.307069, 16.528455));
    }
}
