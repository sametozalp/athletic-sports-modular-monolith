package com.ozalp.auth.business.services;

import com.ozalp.auth.business.dtos.requests.UpdateProfileRequest;
import com.ozalp.auth.business.dtos.responses.UserProfileSimpleResponse;
import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.core.services.BaseService;

public interface UserProfileService extends BaseService<UserProfile> {

    UserProfileSimpleResponse updateProfile(int id, UpdateProfileRequest request);

    UserProfileSimpleResponse getProfileDetail(int id);
}
