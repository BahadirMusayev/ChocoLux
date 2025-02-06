package com.example.chocolux.mapper;

import com.example.chocolux.dao.entity.OwnerEntity;
import com.example.chocolux.model.OwnerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OwnerMapper {
    @Mapping(target = "aboutCompany", source = "aboutCompany")
    OwnerDto mapOwnerEntityToDto(OwnerEntity ownerEntity);
}
