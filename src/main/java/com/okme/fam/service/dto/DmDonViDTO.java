package com.okme.fam.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.okme.fam.domain.DmDonVi} entity.
 */
public class DmDonViDTO implements Serializable {
    
    private String id;

    @NotNull
    @Size(min = 0, max = 20)
    private String ma;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DmDonViDTO)) {
            return false;
        }

        return id != null && id.equals(((DmDonViDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DmDonViDTO{" +
            "id=" + getId() +
            ", ma='" + getMa() + "'" +
            "}";
    }
}
