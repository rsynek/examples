package org.jboss.qa.examples.bpm_taxi.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import org.jboss.qa.examples.bpm_taxi.Customer;
import org.jboss.qa.examples.bpm_taxi.Drive;

enum Customers {

    PETROVICKY (createLukasPetrovicky()),
    JICHA (createVaclavJicha());

    private Customer customer;

    Customers(final Customer customer) {
        this.customer = customer;
    }

    Customer getCustomer() {
        return this.customer;
    }

    static Collection<Customer> getAllCustomers() {
        return EnumSet.allOf(Customers.class).stream()
                .map(item -> item.getCustomer())
                .collect(Collectors.toList());
    }

    private static Customer createLukasPetrovicky() {
        final Customer lukiPetrovicky = new Customer();
        lukiPetrovicky.setName("Lukas");
        lukiPetrovicky.setSurname("Petrovicky");

        final Drive firstDrive = new Drive();
        firstDrive.setFrom(Addresses.PEKARSKA.getAddress());
        firstDrive.setTo(Addresses.PURKYNOVA.getAddress());
        firstDrive.setTaxi(Taxis.TAXI_C.getTaxi());
        firstDrive.setPrice(320.0);

        final Drive secondDrive = new Drive();
        secondDrive.setFrom(Addresses.PURKYNOVA.getAddress());
        secondDrive.setTo(Addresses.K_BABE.getAddress());
        secondDrive.setTaxi(Taxis.TAXI_A.getTaxi());
        secondDrive.setPrice(120.0);

        final List<Drive> history = new ArrayList<>();
        history.add(firstDrive);
        history.add(secondDrive);

        lukiPetrovicky.setHistory(history);
        return lukiPetrovicky;
    }

    private static Customer createVaclavJicha() {
        Customer vaclavJicha = new Customer();
        vaclavJicha.setName("Vaclav");
        vaclavJicha.setSurname("Jicha");
        vaclavJicha.setHistory(new ArrayList<>());

        return vaclavJicha;
    }
}
