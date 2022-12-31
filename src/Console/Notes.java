package Console;

import java.io.File;
import java.io.Serializable;

public class Notes implements Serializable {
    private String notes;
    private String file;

    public Notes(){}

    public Notes(String notes, String file) {
        this.notes = notes;
        this.file = file;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
