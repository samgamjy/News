package by.vasilevich.navigation.commands;

import by.vasilevich.entity.Author;
import by.vasilevich.entity.Commentator;
import by.vasilevich.service.IAuthorService;
import by.vasilevich.service.ICommentatorService;
import by.vasilevich.service.impl.AuthorServiceImpl;
import by.vasilevich.service.impl.CommentatorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.vasilevich.resources.constants.Constants.*;

//import by.vasilevich.service.impl.UserServiceImpl;

public class CommandRegistration implements ICommand {

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session != null) {
//			User user = new User();
			try {
//				user.setLogin(request.getParameter(PARAM_USER_LOGIN));
//				user.setPassword(request.getParameter(PARAM_USER_PASSWORD));
				
//				IUserService userService = new UserServiceImpl();
//				user.setId(userService.createUser(user));
				
//				IUserService userService = new UserServiceImpl();
				if (request.getParameter(PARAM_USER_ROLE).toUpperCase().equals(PARAM_USER_ROLE_AUTHOR)) {
					Author author = new Author();
					author.setFirstName(request.getParameter(PARAM_AUTHOR_FIRSTNAME));
					author.setLastName(request.getParameter(PARAM_AUTHOR_LASTNAME));
					author.setShortName(request.getParameter(PARAM_AUTHOR_SHORT_NAME));
					author.setLogin(request.getParameter(PARAM_USER_LOGIN));
					author.setPassword(request.getParameter(PARAM_USER_PASSWORD));
//					author.setUser(user);
//					userService.createUser(user);
					IAuthorService authorService = new AuthorServiceImpl();
					authorService.createAuthor(author);
				} else {
					Commentator commentator = new Commentator();
					commentator.setNickName(request.getParameter(PARAM_USER_NICKNAME));
					commentator.setLogin(request.getParameter(PARAM_USER_LOGIN));
					commentator.setPassword(request.getParameter(PARAM_USER_PASSWORD));
//					commentator.setUser(user);
//					userService.createUser(user);
					ICommentatorService commentatorService = new CommentatorServiceImpl();
					commentatorService.createCommentator(commentator);
				}


			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return PAGE_MAIN;
	}

}
