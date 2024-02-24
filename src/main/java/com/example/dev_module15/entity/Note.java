package com.example.dev_module15.entity;

import java.util.List;

public class Note {
    private long id;
    private String title;
    private String content;
    private List<Note> noteList;

    public Note() {}
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public List<Note> getNoteList(){
        return noteList;
    }
    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }
    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
