package org.jboss.qa.examples.bpm_taxi.util;

import java.util.Collection;
import java.util.EnumSet;
import java.util.stream.Collectors;
import org.jboss.qa.examples.bpm_taxi.Address;
import org.jboss.qa.examples.bpm_taxi.Location;

enum Addresses {

    PEKARSKA (new Address("Brno, Pekarska 26", new Location(49.192396, 16.601537))),
    CERNOPOLNI (new Address("Brno, Cernopolni 45", new Location(49.207388, 16.616178))),
    NOVOLISENSKA (new Address("Brno, Novolisenska 2702", new Location(49.213878, 16.683052))),
    KURIM (new Address("Kurim, Jungmannova 906", new Location(49.307069, 16.528455))),
    PURKYNOVA (new Address("Brno, Purkynova 111", new Location(49.231435, 16.576252))),
    MORAVANY (new Address("Moravany, Zitna 262", new Location(49.148557, 16.572293))),
    K_BABE (new Address("Brno, K Babe 605", new Location(49.244026, 16.573481)));

    private Address address;

    Addresses(final Address address) {
        this.address = address;
    }

    Address getAddress() {
        return address;
    }

    static Collection<Address> getAllAddresses() {
        return EnumSet.allOf(Addresses.class).stream()
                .map(item -> item.getAddress())
                .collect(Collectors.toList());
    }
}
