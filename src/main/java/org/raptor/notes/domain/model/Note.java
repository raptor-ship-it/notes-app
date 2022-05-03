package org.raptor.notes.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*** -- collection same as table in a RDMS -- */
@Document(collection = "notes")
public class Note {
    /** --- member variables --- */
    @Id
    private String id;
    private String description;

    public Note(final String description ) {
        super();
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Note{");
        sb.append("id='").append(id).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');

        return sb.toString();
    }

}
