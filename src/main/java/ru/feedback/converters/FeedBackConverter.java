package ru.feedback.converters;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import ru.feedback.model.dto.FeedbackDTO;
import ru.feedback.model.entries.Feedback;

@Mapper
@Component
public interface FeedBackConverter {

    FeedBackConverter INSTANCE = Mappers.getMapper(FeedBackConverter.class);


    FeedbackDTO feedbackToFeedbackDto(Feedback feedback);

    Feedback feedbackDTOToFeedback(FeedbackDTO feedbackDTO);
}
