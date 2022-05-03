package org.raptor.notes.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "note")
public class NoteProperties {
    @Value("${uploadDir:/tmp/uploads")
    private String uploadDir;

    public NoteProperties() {
        super();
    }

    public final String getUploadDir() {
        return this.uploadDir;
    }
}
