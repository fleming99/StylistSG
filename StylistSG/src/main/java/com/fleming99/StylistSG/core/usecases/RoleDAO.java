package com.fleming99.StylistSG.core.usecases;

import com.fleming99.StylistSG.core.entities.StylistRole;

public interface RoleDAO{

    StylistRole findRoleByName(String theRoleName);
}
