package ru.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.feedback.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
