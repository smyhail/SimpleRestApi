package com.sub.service;

import com.sub.model.Note;
import com.sub.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public List<Note> getAllNote(){
        return noteRepository.findAll();
    }

    public Note getSingleNote(Long id){
        return noteRepository.findById(id).orElseThrow();
    }

    public Note addNote(Note note){
        return noteRepository.save(note);
    }

    @Transactional
    public Note editNote(Note note ){
        Note noteEdited = noteRepository.findById(note.getId()).orElseThrow();
        noteEdited.setTitle(note.getTitle());
        noteEdited.setBody(note.getBody());
        return noteEdited;
    }

    public void deleteNote(long id){
        noteRepository.deleteById(id);
    }


}
