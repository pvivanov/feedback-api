package ru.feedback.controller;

import ru.feedback.exception.ResourceNotFoundException;
import ru.feedback.model.Feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.feedback.repository.FeedbackRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FeedbackController {

    @Autowired
    FeedbackRepository feedbackRepository;

    @GetMapping("/feedback")
    public List<Feedback> getAllNotes() {
        return feedbackRepository.findAll();
    }

    @PostMapping("/feedback")
    public Feedback createNote(@Valid @RequestBody Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @GetMapping("/feedback/{id}")
    public Feedback getNoteById(@PathVariable(value = "id") Long noteId) {
        return feedbackRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback", "id", noteId));
    }

    @PutMapping("/feedback/{id}")
    public Feedback updateNote(@PathVariable(value = "id") Long noteId,
                               @Valid @RequestBody Feedback feedbackDetails) {

        Feedback feedback = feedbackRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback", "id", noteId));

        feedback.setTitle(feedbackDetails.getTitle());
        feedback.setContent(feedbackDetails.getContent());

        Feedback updatedFeedback = feedbackRepository.save(feedback);
        return updatedFeedback;
    }

    @DeleteMapping("/feedback/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Feedback feedback = feedbackRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback", "id", noteId));

        feedbackRepository.delete(feedback);

        return ResponseEntity.ok().build();
    }
}
