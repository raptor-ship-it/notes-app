package org.raptor.notes.domain.dao;

import org.raptor.notes.domain.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {}

