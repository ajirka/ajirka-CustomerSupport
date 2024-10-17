package org.example.ajirkacustomersupport2;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionIdListener;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionIdListener {
    @Override
    public void sessionIdChanged(HttpSessionEvent se, String oldId) {
        SessionListUtil.updateSessionId(se.getSession(), oldId);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        SessionListUtil.addSession(se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        SessionListUtil.removeSession(se.getSession());
    }
}
