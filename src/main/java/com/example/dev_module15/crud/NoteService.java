package com.example.dev_module15.crud;

import com.example.dev_module15.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements NoteServiceInterface {
    @Autowired
    private NoteRepository noteRepository;

    public void setNoteRepository(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> listAll() {
        return (List<Note>) noteRepository.getAll();
    }

    @Override
    public Note add(Note note) {
        return noteRepository.add(note);
    }

    @Override
    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public void update(Note note) {
        noteRepository.update(note);
    }

    @Override
    public Note getById(long id) {
        return noteRepository.getById(id);
    }
}