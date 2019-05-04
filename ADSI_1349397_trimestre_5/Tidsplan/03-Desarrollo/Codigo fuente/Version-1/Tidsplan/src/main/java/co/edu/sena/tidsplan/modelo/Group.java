/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplan.modelo;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author 1349397
 */
public class Group {
    private String numberGroup;
    private Date startDate;
    private String endDate;
    private char route;
    private String nameStatus;
    private StatusGroup statusGroup;
    private List<GroupHasTrimester> groupHasTrimesters;

    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    public String getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(String numberGroup) {
        this.numberGroup = numberGroup;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public char getRoute() {
        return route;
    }

    public void setRoute(char route) {
        this.route = route;
    }

    public StatusGroup getStatusGroup() {
        return statusGroup;
    }

    public void setStatusGroup(StatusGroup statusGroup) {
        this.statusGroup = statusGroup;
    }

    public List<GroupHasTrimester> getGroupHasTrimesters() {
        return groupHasTrimesters;
    }

    public void setGroupHasTrimesters(List<GroupHasTrimester> groupHasTrimesters) {
        this.groupHasTrimesters = groupHasTrimesters;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.numberGroup);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Group other = (Group) obj;
        if (!Objects.equals(this.numberGroup, other.numberGroup)) {
            return false;
        }
        return true;
    }
    

}
