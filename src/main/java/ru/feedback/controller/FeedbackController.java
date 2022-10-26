package ru.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.feedback.converters.FeedBackConverter;
import ru.feedback.exception.ResourceNotFoundException;
import ru.feedback.model.dto.FeedbackDTO;
import ru.feedback.model.entries.Feedback;
import ru.feedback.repository.FeedbackRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FeedbackController {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    FeedBackConverter feedBackConverter;

    @GetMapping("/feedback")
    public List<Feedback> getAllNotes() {
        return feedbackRepository.findAll();
    }

    @PostMapping("/feedback")
    public Feedback createNote(@Valid @RequestBody FeedbackDTO feedback) {
        return feedbackRepository.save(feedBackConverter.feedbackDTOToFeedback(feedback));
    }

    @GetMapping("/feedback/{id}")
    public Feedback getNoteById(@PathVariable(value = "id") Long noteId) {
        return feedbackRepository.findById(noteId)
                                 .orElseThrow(() -> new ResourceNotFoundException("Feedback", "id", noteId));
    }

    @PutMapping("/feedback/{id}")
    public Feedback updateNote(@PathVariable(value = "id") Long noteId,
                               @Valid @RequestBody FeedbackDTO feedbackDetails) {

        Feedback feedback = feedbackRepository.findById(noteId)
                                              .orElseThrow(() -> new ResourceNotFoundException("Feedback", "id", noteId));

        feedback.setTitle(feedbackDetails.getTitle());
        feedback.setContent(feedbackDetails.getContent());

        return feedbackRepository.save(feedback);
    }

    @DeleteMapping("/feedback/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Feedback feedback = feedbackRepository.findById(noteId)
                                              .orElseThrow(() -> new ResourceNotFoundException("Feedback", "id", noteId));

        feedbackRepository.delete(feedback);

        return ResponseEntity.ok()
                             .build();
    }
}
