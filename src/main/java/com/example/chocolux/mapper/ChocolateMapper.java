package com.example.chocolux.mapper;

import com.example.chocolux.dao.entity.ChocolateEntity;
import com.example.chocolux.model.ChocolateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChocolateMapper {
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    ChocolateEntity mapChocolateDtoInputToEntity(ChocolateDto chocolateDto);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    ChocolateDto mapEntityToChocolateDtoOutput(ChocolateEntity chocolateEntity);
}
