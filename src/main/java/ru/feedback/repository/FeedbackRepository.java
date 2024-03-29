package ru.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.feedback.model.entries.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
