package com.fastesttyper.fastesttyperservice.infrastructure.persistence.mapper;

import com.fastesttyper.fastesttyperservice.domain.model.User;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities.OnlineAvailableUserEntity;
import org.springframework.stereotype.Component;

@Component
public class OnlineAvailableUserEntityMapper {
    public OnlineAvailableUserEntity toEntity(User user){
        OnlineAvailableUserEntity onlineAvailableUserEntity = new OnlineAvailableUserEntity();
        onlineAvailableUserEntity.setId(user.getId());
        onlineAvailableUserEntity.setAlias(user.getAlias());
        onlineAvailableUserEntity.setEmail(user.getEmail());
        onlineAvailableUserEntity.setPoints(user.getPoints());
        return onlineAvailableUserEntity;
    }

    public User toDomain(OnlineAvailableUserEntity entity) {
        return new User(entity.getId(), entity.getAlias(), entity.getEmail(), "??", entity.getPoints());
    }
}
