package com.donc.entities;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;

/**
 * Created by donovan on 15/10/19.
 */
@Embeddable
public class ClientConsultantKey implements Serializable {

    private Client client;
    private Consultant consultant;

    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne
    public Consultant getConsultant() {
        return consultant;
    }

    public void setConsultant(Consultant consultant) {
        this.consultant = consultant;
    }
}
