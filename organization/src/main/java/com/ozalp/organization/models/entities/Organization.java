package com.ozalp.organization.models.entities;

import com.ozalp.core.models.entites.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "organizations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Organization extends BaseEntity {

    @Column(nullable = false)
    private int ownerUserProfileId;

    @Column(nullable = false)
    private String name;

    @Column
    private String logoUrl;

    @Column(nullable = false)
    private boolean active = true;

}