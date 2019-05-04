package co.edu.sena.tisdplandao.model.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

import static sun.security.internal.interfaces.TlsMasterSecret.serialVersionUID;

public class SpecialityDTO  implements Serializable{
    private String nameSpeciality;
    private boolean status;
    private byte[] photo;

    public SpecialityDTO() {
    }


    public String getNameSpeciality() {
        return nameSpeciality;
    }

    public void setNameSpeciality(String nameSpeciality) {
        this.nameSpeciality = nameSpeciality;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "SpecialityDTO{" +
                "nameSpeciality='" + nameSpeciality + '\'' +
                ", status=" + status +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecialityDTO that = (SpecialityDTO) o;
        return Objects.equals(nameSpeciality, that.nameSpeciality);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nameSpeciality);
    }
}
