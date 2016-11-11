package org.jboss.qa.examples.bpm_taxi.util;

import java.util.Collection;
import java.util.EnumSet;
import java.util.stream.Collectors;
import org.jboss.qa.examples.bpm_taxi.Taxi;

enum Taxis {

    TAXI_A (new Taxi(Addresses.NOVOLISENSKA.getAddress(), "5U97943", false)),
    TAXI_B (new Taxi(Addresses.CERNOPOLNI.getAddress(), "1B35623", false)),
    TAXI_C (new Taxi(Addresses.KURIM.getAddress(), "1BK3850", false)),
    TAXI_D (new Taxi(Addresses.K_BABE.getAddress(), "1E87368", true));

    private Taxi taxi;

    Taxis(final Taxi taxi) {
        this.taxi = taxi;
    }

    Taxi getTaxi() {
        return this.taxi;
    }

    static Collection<Taxi> getAllTaxis() {
        return EnumSet.allOf(Taxis.class).stream()
                .map(item -> item.getTaxi())
                .collect(Collectors.toList());
    }
}
