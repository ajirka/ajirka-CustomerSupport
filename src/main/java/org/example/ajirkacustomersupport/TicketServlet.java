package org.example.ajirkacustomersupport;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;



@WebServlet(name = "ticket", value = "/ticket")
@MultipartConfig(fileSizeThreshold = 5_242_880, maxFileSize = 20_971_5201, maxRequestSize = 41_943_040L)

public class TicketServlet extends HttpServlet {
    private volatile int SUPPORT_ID =1;
    private Map<Integer, Ticket> ticketDB = new LinkedHashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");

        String action = request.getParameter("action");
        if(action == null){
            action = "list";
        }
        switch(action){
            case "createTicket" -> showTicketForm(request, response);
            case "view" -> viewTicket(request, response);
            case "download" -> downloadAttachment(request, response);
            default -> listTickets(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");

        String action = request.getParameter("action");
        if(action == null){
            action = "list";
        }
        switch(action){
            case"create" -> createTicket(request, response);
            default -> response.sendRedirect("ticket");

        }
    }

    private void createTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Ticket ticket = new Ticket();
        ticket.setName(request.getParameter("name"));
        ticket.setSubject(request.getParameter("subject"));
        ticket.setTicketSummary(request.getParameter("body"));

        Part file = request.getPart("file1");
        if(file != null){
            Attachment attachment = this.processAttachment(file);
            if(attachment != null){
                ticket.setAttachments(attachment);
            }
        }
        int id;
        synchronized (this){
            id = this.SUPPORT_ID++;
            ticketDB.put(id,ticket);
        }
        response.sendRedirect("ticket?action=view&ticketId=" + id);
    }

    private void listTickets(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        PrintWriter out = response.getWriter();

        out.println("<html><body><h2>Ticket Posts<h2>");
        out.println("<a href=\"ticket?action=createTicket\">Create Ticket</a><br>");

        if(ticketDB.size() == 0){
            out.println("No ticket posts");
        }else{
            for(int id: ticketDB.keySet()){
                Ticket ticket = ticketDB.get(id);
                out.println("Ticket #" + id);
                out.println(": <a href=\"ticket?action=view&ticketId" + id + "\">");
                out.println(ticket.getName() + "</a><br>");
            }
        }
        out.println("</body></html>");
    }

    private void downloadAttachment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String idString = request.getParameter("ticketId");
        Ticket ticket = getTicket(idString, response);

        String name = request.getParameter("file1");
        if(name == null){
            response.sendRedirect("ticket?action=view&ticketId" + idString);
            return;
        }
        Attachment attachment = ticket.getAttachments();
        if(attachment == null){
            response.sendRedirect("ticket?action=view&ticketId" + idString);
            return;
        }

        response.setHeader("Content-Disposition", "file1; filename=" + attachment.getName());
        response.setContentType("application/octet-stream");
        ServletOutputStream out = response.getOutputStream();
        out.write(attachment.getContents());
    }

    private void viewTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String idString = request.getParameter("ticketId");
        Ticket ticket = getTicket(idString, response);
        PrintWriter out = response.getWriter();
        out.println("<html><body><h2>Ticket Posts<h2>");
        out.println("<h3>Name: " + ticket.getName() + "</h3>");
        out.println("<h3>Subject: " + ticket.getSubject()+ "</h3>");
        out.println("<p>Summary: "+ ticket.getTicketSummary() +"</p>");
        if(ticket.hasImage()){
            out.println("<a href=\"ticket?action=download&ticketId" + idString+ "&attachment="+ ticket.getAttachments().getName()+
                    "\">" + ticket.getAttachments().getName()+ "</a><br>");
        }
        out.println("<a href=\"ticket\">Return to ticket list</a>");
        out.println("</body></html>");
    }

    private void showTicketForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        PrintWriter out = response.getWriter();

        out.println("<html><body><h2>Ticket Posts<h2>");
        out.println("<form method=\"POST\" action = \"ticket\" enctype=\"multipart/form-data\">");
        out.println("<input type=\"hidden\" name=\"action\" value=\"create\">");
        out.println("Name:<br>");
        out.println("<input type=\"text\" name=\"name\"><br>");
        out.println("Subject:<br>");
        out.println("<input type=\"text\" name=\"subject\"><br>");
        out.println("Body:<br>");
        out.println("<textarea name=\"body\" rows=\"25\" cols=\"100\"></textarea><br>");
        out.println("<b>Attachments</b><br>");
        out.println("<input type=\"file\" name=\"file1\"><br>");
        out.println("<input type=\"submit\" value=\"Submit\"><br>");
        out.println("</form></body></html>");

    }

    private Attachment processAttachment(Part file) throws IOException{
        InputStream in = file.getInputStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int read;
        final byte[] bytes = new byte[1024];
        while ((read = in.read(bytes)) != -1) {
            out.write(bytes,0,read);
        }
        Attachment attachment = new Attachment();
        attachment.setName(file.getSubmittedFileName());
        attachment.setContents(out.toByteArray());
        return attachment;
    }

    private Ticket getTicket(String idString, HttpServletResponse response) throws ServletException, IOException{
        if(idString == null || idString.length() == 0){
            response.sendRedirect("ticket");
            return null;
        }
        try{
            int id = Integer.parseInt(idString);
            Ticket ticket = ticketDB.get(id);
            if(ticket == null){
                response.sendRedirect("ticket");
                return null;
            }
            return ticket;
        } catch (Exception e){
            response.sendRedirect("ticket");
            return null;
        }
    }

}
