package ru.feedback.converters;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import ru.feedback.model.dto.FeedbackDTO;
import ru.feedback.model.entries.Feedback;

import static org.mapstruct.InjectionStrategy.FIELD;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Component
@Mapper(componentModel = SPRING, injectionStrategy = FIELD)
public interface FeedBackConverter {

    FeedBackConverter INSTANCE = Mappers.getMapper(FeedBackConverter.class);


    FeedbackDTO feedbackToFeedbackDto(Feedback feedback);

    Feedback feedbackDTOToFeedback(FeedbackDTO feedbackDTO);
}
