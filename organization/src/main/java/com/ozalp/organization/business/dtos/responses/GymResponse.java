package com.ozalp.organization.business.dtos.responses;

import com.ozalp.auth.business.dtos.responses.UserProfileSimpleResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GymResponse {

    private int id;

    private UserProfileSimpleResponse owner;

    private String name;

    private String logoUrl;

}
