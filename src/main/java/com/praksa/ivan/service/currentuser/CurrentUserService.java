package com.praksa.ivan.service.currentuser;

import com.praksa.ivan.domain.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
