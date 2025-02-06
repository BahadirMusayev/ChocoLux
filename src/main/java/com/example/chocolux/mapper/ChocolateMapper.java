package com.example.chocolux.mapper;

import com.example.chocolux.dao.entity.ChocolateEntity;
import com.example.chocolux.model.ChocolateDtoInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChocolateMapper {
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    ChocolateEntity mapChocolateDtoInputToEntity(ChocolateDtoInput chocolateDtoInput);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    ChocolateDtoInput mapEntityToChocolateDtoOutput(ChocolateEntity chocolateEntity);

    List<ChocolateDtoInput> mapEntityToChocolateDtoOutputs(List<ChocolateEntity> chocolateEntities);
}
