package by.vasilevich.resources.constants;

public class Constants {
    public static final String PATH_JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String ADDRESS_JDBC = "jdbc:mysql://localhost:3306/newsdb";
    public static final String PARAM_LOGIN = "root";
    public static final String PARAM_PASS = "admin";
    
    public static final String SESSION_PARAM_USER = "loginUser";
    public static final String PARAM_PAGE = "page";
    public static final String PARAM_USER_LOGIN = "login"; 
    public static final String PARAM_USER_PASSWORD = "password";    
    public static final String PARAM_USER_NICKNAME = "nickname";
    public static final String PARAM_USER_ROLE = "role";
    public static final String PARAM_USER_ROLE_AUTHOR = "AUTHOR";
    public static final String PARAM_USER_ROLE_COMMENTATOR = "COMMENTATOR";
    
    
    public static final String PARAM_AUTHOR_FIRSTNAME = "firstname"; 
    public static final String PARAM_AUTHOR_LASTNAME = "lastname"; 
    public static final String PARAM_AUTHOR_SHORT_NAME = "shortname"; 


    public static final String PARAM_NEWS_BEAN_LIST = "newsBeanList";
    public static final String PARAM_NEWS_ID = "newsID";
    public static final String PARAM_NEWS_ITEM = "news";


    
    
    public static final int INVALID_PARAM = -1;
    
    // CREATION SQL FUNCTIONS
    public static final String SQL_INSERT_AUTHOR = "INSERT INTO authors (first_name, last_name, short_name, user_id) values (?,?,?, ?)";
    public static final String SQL_INSERT_USER = "INSERT INTO users (login, password) values (?,?)";
    public static final String SQL_INSERT_NEWS = "INSERT INTO news (title, short_text, full_text, creation_date, modification_date) values (?,?,?,?,?)";
    public static final String SQL_INSERT_COMMENT = "INSERT INTO comments (comment_text, creation_date, news_id) values (?,?,?)";
    public static final String SQL_INSERT_COMMMENTATOR = "INSERT INTO commentators (nickname, user_id) values (?,?)";
    
    
    
    public static final String SQL_CHECK_USER_ITEM = "SELECT * FROM users WHERE login LIKE ?";
    
    // GETTER SQL FUNCTIONS
    public static final String SQL_GET_AUTHOR = "SELECT * FROM authors WHERE (user_id = ?)";
    public static final String SQL_GET_ALL_AUTHOR = "SELECT * FROM authors";
    public static final String SQL_GET_USER = "SELECT * FROM users WHERE (id = ?)";
    public static final String SQL_GET_ALL_USER = "SELECT * FROM users";
    public static final String SQL_GET_COMMENT = "SELECT * FROM comments WHERE (id = ?)";
    public static final String SQL_GET_ALL_COMMENTS = "SELECT * FROM comments";
    public static final String SQL_GET_NEWS = "SELECT * FROM authors WHERE (user_id = ?)";
    public static final String SQL_GET_ALL_NEWS = "SELECT * FROM news";
    public static final String SQL_GET_COMMENTATOR = "SELECT * FROM commentators WHERE (user_id = ?)";
    public static final String SQL_GET_ALL_COMMENTATORS = "SELECT * FROM commentators";
    public static final String SQL_GET_LAST_10_NEWS = "SELECT * FROM news ORDER BY id DESC LIMIT 10";
//    public static final String SQL_GET_ALL_NEWS_BY_AUTHOR = "SELECT * FROM news WHERE ()";
    
    // DELETE SQL FUNCTIONS
    public static final String SQL_DELETE_AUTHOR = "DELETE FROM authors WHERE (user_id = ?)";
    public static final String SQL_DELETE_USER = "DELETE FROM users WHERE (id = ?)";
    public static final String SQL_DELETE_COMMENT = "DELETE FROM comments WHERE (id = ?)";
    public static final String SQL_DELETE_NEWS = "DELETE FROM news WHERE (id = ?)";
    public static final String SQL_DELETE_COMMENTATOR = "DELETE FROM commentators WHERE (user_id = ?)";
    
    // PAGES    
//    public static final String PAGE_LIST_AUTHORS = "/pages/listClients.jsp";
//    public static final String PAGE_LIST_USERS = "/pages/listClients.jsp";
//    public static final String PAGE_NEWS = "/pages/clientInfo.jsp";
    public static final String PAGE_ERROR_401 = "/pages/Errors/401.jsp";
    public static final String PAGE_ERROR_404 = "/pages/Errors/404.jsp";
//    public static final String PAGE_PROFILE_CLIENT = "/pages/profileClient.jsp";
//    public static final String PAGE_CONTROL_SERVICE_CLIENT = "/pages/clientControlService.jsp";
//    public static final String PAGE_LIST_ORDERS = "/pages/listOrder.jsp";

    public static final String PAGE_MAIN = "/index.jsp";    
    public static final String PAGE_LOGIN = "/pages/loginUser.jsp";
    public static final String PAGE_NEWS_LIST = "/pages/newsList.jsp";
    public static final String PAGE_NEWS_ITEM = "/pages/newsItem.jsp";

}
