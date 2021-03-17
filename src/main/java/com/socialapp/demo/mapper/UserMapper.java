package com.socialapp.demo.mapper;

import com.socialapp.demo.dto.UserRequestDto;
import com.socialapp.demo.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper(componentModel = "spring")
@Repository
public interface UserMapper {
    User mapToUser(UserRequestDto userRequestDto);
}
