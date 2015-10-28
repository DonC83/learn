package com.donc.entities;

import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by donovan on 15/10/23.
 */
public class ProjectAssociationId implements Serializable {

    public static final long serialVersionUid = 1l;

    private long employee_Id;
    private long project_Id;

    public long getEmployee_Id() {
        return employee_Id;
    }

    public void setEmployee_Id(long employee_Id) {
        this.employee_Id = employee_Id;
    }

    public long getProject_Id() {
        return project_Id;
    }

    public void setProject_Id(long project_Id) {
        this.project_Id = project_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectAssociationId that = (ProjectAssociationId) o;
        return Objects.equals(employee_Id, that.employee_Id) &&
                Objects.equals(project_Id, that.project_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_Id, project_Id);
    }
}
