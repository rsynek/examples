package org.jboss.qa.examples.bpm_taxi;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
public class Location implements java.io.Serializable {

    private static final double EARTH_RADIUS_METERS = 6371000;

    @XmlAttribute
    private double lattitude;

    @XmlAttribute
    private double longitude;

    //JAXB only
    public Location() {}

    public Location(final double lattitude, final double longitude) {
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public double getLattitude() {
        return lattitude;
    }

    public double getLongitude() {
        return longitude;
    }
    
    public void setLattitude(double latt) {
        this.lattitude = latt;
    }

    public void setLongitude(double longit) {
        this.longitude = longit;
    }

    public double computeDistance(final Location secondLocation) {
        if(secondLocation == null) {
            throw new IllegalArgumentException("Location cannot be null.");
        }
        double secondLattitude = secondLocation.getLattitude();
        double secondLongitude = secondLocation.getLongitude();

        double dLat = Math.toRadians(secondLattitude - lattitude);
        double dLng = Math.toRadians(secondLongitude - longitude);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lattitude)) * Math.cos(Math.toRadians(secondLattitude)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double dist = EARTH_RADIUS_METERS * c;

        return dist;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;

        Location location = (Location) o;

        if (Double.compare(location.lattitude, lattitude) != 0) return false;
        return Double.compare(location.longitude, longitude) == 0;

    }

    public String toString() {
        return "latt: " + lattitude + ", long: " + longitude;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(lattitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
