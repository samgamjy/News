package by.vasilevich.navigation.commands;

import by.vasilevich.entity.News;
import by.vasilevich.service.INewsService;
import by.vasilevich.service.impl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.vasilevich.resources.constants.Constants.*;

/**
 * Created by sam on 12.11.2016.
 */

public class CommandItemNews implements ICommand {
    @Override
    public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int newsID = (Integer)request.getAttribute(PARAM_NEWS_ID);
        INewsService newsServices = new NewsServiceImpl();
        News news = newsServices.getNews(newsID);

        if (news != null) {
            request.setAttribute(PARAM_NEWS_ITEM, news);
            return PAGE_NEWS_ITEM;
        }
        return PAGE_ERROR_404;
    }
}
