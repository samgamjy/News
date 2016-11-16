package by.vasilevich.navigation.commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ICommand {

	String executeCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	
}
