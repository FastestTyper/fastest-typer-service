package com.fastesttyper.fastesttyperservice.infrastructure.persistence.mapper;

import com.fastesttyper.fastesttyperservice.domain.model.Lesson;
import com.fastesttyper.fastesttyperservice.domain.model.LessonType;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities.LessonEntity;
import com.fastesttyper.fastesttyperservice.infrastructure.persistence.entities.LessonTypeEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class LessonEntityMapper {
    private final Map<Long, LessonType> lessonTypeMap = new HashMap<>() {{
        put(0L, LessonType.VIDEO);
        put(1L, LessonType.TEXT);
    }};

    private final Map<LessonType, LessonTypeEntity> lessonTypeEntityMapMap = new HashMap<>() {{
        put(LessonType.VIDEO, new LessonTypeEntity(0L, "video"));
        put(LessonType.TEXT, new LessonTypeEntity(1L, "text"));
    }};

    public Lesson toDomain(LessonEntity lesson) {
        return new Lesson(lesson.getId(), lesson.getTitle(), lesson.getText(), toDomain(lesson.getType()), "??");
    }

    public List<Lesson> toDomain(List<LessonEntity> lesson) {
        return lesson.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private LessonType toDomain(LessonTypeEntity lessonTypeEntity) {
        return lessonTypeMap.getOrDefault(lessonTypeEntity.getId(), LessonType.TEXT);
    }

    public LessonEntity toEntity(Lesson lessonEntity) {
        return new LessonEntity(lessonEntity.getId(), lessonEntity.getTitle(), lessonEntity.getText(), toEntity(lessonEntity.getType()));
    }

    public List<LessonEntity> toEntity(List<Lesson> lesson) {
        return lesson.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    private LessonTypeEntity toEntity(LessonType lessonType) {
        return lessonTypeEntityMapMap.getOrDefault(lessonType, lessonTypeEntityMapMap.get(LessonType.TEXT));
    }
}
