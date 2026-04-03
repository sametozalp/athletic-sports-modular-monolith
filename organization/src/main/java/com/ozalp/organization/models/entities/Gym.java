package com.ozalp.organization.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gyms")
@NoArgsConstructor
@Getter
@Setter
public class Gym extends Organization {

    public Gym(int ownerUserProfileId, String name, String logoUrl, boolean active) {
        super(ownerUserProfileId, name, logoUrl, active);
    }
}
