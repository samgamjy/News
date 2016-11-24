package by.vasilevich.navigation.commands;

import by.vasilevich.entity.News;
import by.vasilevich.entity.User;
import by.vasilevich.navigation.bean.NewsBean;
import by.vasilevich.service.INewsService;
import by.vasilevich.service.IUserService;
import by.vasilevich.service.impl.NewsServiceImpl;
import by.vasilevich.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.vasilevich.resources.constants.Constants.*;

public class CommandLogin implements ICommand {

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session != null) {
		if (session.getAttribute(SESSION_PARAM_USER) == null){
//			String urlPath = request.getRequestURI().substring(request.getContextPath().length());
			
			String login = request.getParameter(PARAM_USER_LOGIN);
			String password = request.getParameter(PARAM_USER_PASSWORD);
			
			IUserService userServiceImpl = new UserServiceImpl();
			User user = userServiceImpl.login(login, password);
			String page;
			if (user == null) {
				session.removeAttribute(SESSION_PARAM_USER);
				page = PAGE_ERROR_401;
				
			} else {
				session.setAttribute(SESSION_PARAM_USER, user.getLogin());
				addListNewsIntoRequest(request, response);
//				request.setAttribute();
				page = PAGE_NEWS_LIST;
			}
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
			requestDispatcher.forward(request, response);
			return page;			
		}
		}
		return null;
	}



	private void addListNewsIntoRequest(HttpServletRequest request, HttpServletResponse response) {
		INewsService newsService = new NewsServiceImpl();
		List<News> newsList = newsService.getLast10News();

		List<NewsBean> newsBeanList = getNewsBeanList(newsList);
		request.setAttribute(PARAM_NEWS_BEAN_LIST, newsBeanList);

	}

	private List<NewsBean> getNewsBeanList(List<News> newsList) {
		List<NewsBean> newsBean = new ArrayList<NewsBean>();
		for (News news : newsList) {
			NewsBean bean = new NewsBean();
			bean.setNewsID(news.getNewsID());
			bean.setTitle(news.getTitle());
			bean.setShortText(news.getShortText());
			newsBean.add(bean);
		}
		return newsBean;
	}
}
