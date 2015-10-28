package com.donc.entities;

import javax.persistence.*;

/**
 * Created by donovan on 15/10/23.
 */
@Entity
@Table(name = "project_employee")
@IdClass(ProjectAssociationId.class)
public class ProjectAssociation {

    private long employee_Id;
    private long project_Id;
    private Employee employee;
    private Project project;

    @Id
    public long getEmployee_Id() {
        return employee_Id;
    }

    public void setEmployee_Id(long employee_Id) {
        this.employee_Id = employee_Id;
    }

    @Id
    public long getProject_Id() {
        return project_Id;
    }

    public void setProject_Id(long project_Id) {
        this.project_Id = project_Id;
    }

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "employee_id", referencedColumnName = "id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "project_id", referencedColumnName = "id")
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
