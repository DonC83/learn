package com.donc.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by donovan on 15/10/19.
 */
@Entity
@Table(name = "client_consultant")
@AssociationOverrides({
        @AssociationOverride(name = "pk.client", joinColumns = @JoinColumn(name = "client_id")),
        @AssociationOverride(name = "pk.consultant", joinColumns = @JoinColumn(name = "consultant_id"))
})
public class ClientConsultant {

    private ClientConsultantKey pk;

    @EmbeddedId
    public ClientConsultantKey getPk() {
        return pk;
    }

    public void setPk(ClientConsultantKey pk) {
        this.pk = pk;
    }

    @Transient
    public Client getClient() {
        return getPk().getClient();
    }

    public void setClient(Client client) {
        getPk().setClient(client);
    }

    @Transient
    public Consultant getConsultant() {
        return getPk().getConsultant();
    }

    public void setConsultant(Consultant consultant) {
        getPk().setConsultant(consultant);
    }

}
