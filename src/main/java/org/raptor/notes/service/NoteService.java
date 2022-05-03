package org.raptor.notes.service;


import org.apache.commons.lang3.StringUtils;
import org.raptor.notes.domain.dao.NoteRepository;
import org.raptor.notes.domain.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    /** -- member variables -- */

    @Autowired
    private NoteRepository noteRepository;

    public NoteService() {
        super();
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNote(final String noteId) {
        Note note = null;

        if ( !StringUtils.isEmpty(noteId) ) {
            note = Optional.of(noteRepository.findById(noteId)).get().
                    orElse(null);
        }

        return note;
    }


    public Note addNote( final String description ) {
        Note note = null;
        if ( !StringUtils.isEmpty(description) ) {
            note = noteRepository.save(new Note(description));
        }

        return note;
    }

}
