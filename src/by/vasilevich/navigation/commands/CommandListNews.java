package by.vasilevich.navigation.commands;

import by.vasilevich.entity.News;
import by.vasilevich.navigation.bean.NewsBean;
import by.vasilevich.service.INewsService;
import by.vasilevich.service.impl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.vasilevich.resources.constants.Constants.*;

/**
 * Created by sam on 12.11.2016.
 */
public class CommandListNews implements ICommand {
    @Override
    public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        INewsService newsService = new NewsServiceImpl();
        List<News> newsList = newsService.getLast10News();

        List<NewsBean> newsBeanList = getNewsBeanList(newsList);
        request.setAttribute(PARAM_NEWS_BEAN_LIST, newsBeanList);

        return PAGE_NEWS_LIST;
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
