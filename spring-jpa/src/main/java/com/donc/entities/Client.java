package com.donc.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by donovan on 15/10/19.
 */
@Entity
public class Client {

    private int id;
    private String name;
    private List<ClientConsultant> clientConsultants;

    @Id
    @Column(unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.client")
    public List<ClientConsultant> getClientConsultants() {
        return clientConsultants;
    }

    public void setClientConsultants(List<ClientConsultant> clientConsultants) {
        this.clientConsultants = clientConsultants;
    }
}
