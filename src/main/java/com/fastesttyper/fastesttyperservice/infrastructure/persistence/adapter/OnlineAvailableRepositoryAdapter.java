package com.fastesttyper.fastesttyperservice.infrastructure.persistence.adapter;

import com.fastesttyper.fastesttyperservice.domain.model.User;
import com.fastesttyper.fastesttyperservice.domain.repositories.OnlineAvailableRepository;
import com.fastesttyper.fastesttyperservice.infrastructure.event.OnlineAvailableEventPublisher;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities.OnlineAvailableUserEntity;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.jpa.OnlineAvailableUserJPA;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.mapper.OnlineAvailableUserEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OnlineAvailableRepositoryAdapter implements OnlineAvailableRepository {

    private final OnlineAvailableUserJPA onlineAvailableUserJPA;
    private final OnlineAvailableUserEntityMapper onlineAvailableUserEntityMapper;
    private final OnlineAvailableEventPublisher onlineAvailableEventPublisher;

    public OnlineAvailableRepositoryAdapter(OnlineAvailableUserJPA onlineAvailableUserJPA, OnlineAvailableUserEntityMapper onlineAvailableUserEntityMapper, OnlineAvailableEventPublisher onlineAvailableEventPublisher) {
        this.onlineAvailableUserJPA = onlineAvailableUserJPA;
        this.onlineAvailableUserEntityMapper = onlineAvailableUserEntityMapper;
        this.onlineAvailableEventPublisher = onlineAvailableEventPublisher;
    }

    @Override
    public void available(User user) {
        OnlineAvailableUserEntity onlineAvailableUserEntity = onlineAvailableUserEntityMapper.toEntity(user);
        onlineAvailableUserJPA.save(onlineAvailableUserEntity);
        onlineAvailableEventPublisher.changeAvailablePublisher();
    }

    @Override
    public void notAvailable(User user) {
        OnlineAvailableUserEntity onlineAvailableUserEntity = onlineAvailableUserEntityMapper.toEntity(user);
        onlineAvailableUserJPA.delete(onlineAvailableUserEntity);
        onlineAvailableEventPublisher.changeAvailablePublisher();
    }

    @Override
    public List<User> availables() {
        List<OnlineAvailableUserEntity> onlineAvailableUserEntities = onlineAvailableUserJPA.findAll();
        return onlineAvailableUserEntities.stream()
                .map(onlineAvailableUserEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
