package org.jboss.qa.examples.bpm_taxi;

import java.util.UUID;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {
        "id"
})
class Entity {

    @XmlID
    @XmlAttribute
    private String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }

}
