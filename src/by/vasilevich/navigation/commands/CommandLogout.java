package by.vasilevich.navigation.commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.vasilevich.resources.constants.Constants.*;

/**
 * Created by sam on 05.11.2016.
 */
public class CommandLogout implements ICommand {
    @Override
    public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null) {
            if (session.getAttribute(SESSION_PARAM_USER) != null) {
                session.removeAttribute(SESSION_PARAM_USER);
            }
        }
        return PAGE_MAIN;
    }
}
