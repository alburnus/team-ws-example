package pl.alburnus.springws.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name"
})
// Only on root element!
@XmlRootElement(name = "TeamRequest", namespace = "http://alburnus.pl/springws/ws/team")
public class TeamRequest {

    @XmlElement(required = true)
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
