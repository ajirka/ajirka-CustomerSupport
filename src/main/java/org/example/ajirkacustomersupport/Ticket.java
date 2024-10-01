package org.example.ajirkacustomersupport;

public class Ticket {
    private String name;
    private String subject;
    private String ticketSummary;
    private Attachment attachments;

    public Ticket(String name, String subject, String ticketSummary, Attachment attachments) {
        this.name = name;
        this.subject = subject;
        this.ticketSummary = ticketSummary;
        this.attachments = attachments;
    }

    public Ticket(){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTicketSummary() {
        return ticketSummary;
    }

    public void setTicketSummary(String ticketSummary) {
        this.ticketSummary = ticketSummary;
    }

    public Attachment getAttachments() {
        return attachments;
    }

    public void setAttachments(Attachment attachments) {
        this.attachments = attachments;
    }

    public boolean hasImage() {
        return attachments.getName().length() > 0 && attachments.getContents().length > 0;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", ticketSummary='" + ticketSummary + '\'' +
                ", attachments=" + attachments +
                '}';
    }
}
