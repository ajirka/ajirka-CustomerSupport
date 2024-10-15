package org.example.ajirkacustomersupport2;
import java.util.Arrays;
public class Attachment {
    private String name;
    private byte[] contents;

    public Attachment() {
        super();
    }

    public Attachment(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContents() {
        return contents;
    }

    public void setContents(byte[] contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "name='" + name + '\'' +
                ", contents=" + Arrays.toString(contents) +
                '}';
    }
}
