package org.kuroneko.starpivot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="components")
public class Component {
    @Id
    @Column(length=20,name = "name")
    public String name;
    @Column(name = "installation_status")
    public boolean isInstalled;
    @Column(length=10,name = "version")
    public String version;

    public String getName() {
        return name;
    }

    public boolean getIsInstalled() {
        return isInstalled;
    }

    public void setIsInstalled(boolean installed) {
        isInstalled = installed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
