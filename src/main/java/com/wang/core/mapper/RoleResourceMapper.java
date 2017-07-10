package com.wang.core.mapper;

import com.wang.core.entity.RoleResource;

public interface RoleResourceMapper {
    int insert(RoleResource record);

    int insertSelective(RoleResource record);
}