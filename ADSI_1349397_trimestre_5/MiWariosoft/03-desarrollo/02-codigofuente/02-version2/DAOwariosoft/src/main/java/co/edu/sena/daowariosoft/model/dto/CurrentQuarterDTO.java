/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.model.dto;




import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author 1349397
 */
public class CurrentQuarterDTO {
   public String idCurrentQuarter;
   public Date startDate;
   public Date endDate;

    public String getIdCurrentQuarter() {
        return idCurrentQuarter;
    }

    public void setIdCurrentQuarter(String idCurrentQuarter) {
        this.idCurrentQuarter = idCurrentQuarter;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idCurrentQuarter);
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
        final CurrentQuarterDTO other = (CurrentQuarterDTO) obj;
        if (!Objects.equals(this.idCurrentQuarter, other.idCurrentQuarter)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CurrentQuarterDTO{" + "id_Current_Quarter=" + idCurrentQuarter + ", start_Date=" + startDate + ", end_Date=" + endDate + '}';
    }

    public void setStartDate(String __02__22) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
}
