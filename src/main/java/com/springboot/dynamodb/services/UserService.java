package com.springboot.dynamodb.services;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import com.springboot.dynamodb.dto.UserDTO;
import com.springboot.dynamodb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private DynamoDBMapper mapper;

    public UserDTO insertIntoDynamoDB(UserDTO dto) {
        User user = new User();
        user.setUserId(Long.parseLong(dto.getStudentId()));
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        mapper.save(user);
        return convertDto(user);
    }

    public UserDTO convertDto(User user){
        return new UserDTO(
                user.getUserId().toString(),
                user.getFirstName(),
                user.getLastName()
        );
    }
}
