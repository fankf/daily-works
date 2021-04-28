package com.fankf.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author fankunfeng
 * 2021-04-28 17:44
 */
@Mapper
public interface PersonToUserMapper {

    PersonToUserMapper INSTANCE = Mappers.getMapper( PersonToUserMapper.class );

    @Mapping(source = "name",target = "username")
    User personToUser(Person person);
}
