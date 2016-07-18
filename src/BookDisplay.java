package javademo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;


@WebServlet("/BookDisplay")
public class BookDisplay extends HttpServlet {
    public static Collection<User> collection = new ArrayList<User>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        query();
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("test", collection);//存值
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);//开始跳转
        collection = null;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }


    private void query() {
        Connection conn = null;
        Statement stml = null;

        String url = "jdbc:mysql://localhost:3306/douban?" + "user=root&password=qweszxcsq&useUnicode=true&characterEncoding=utf8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载数据库驱动程序!");
            conn = DriverManager.getConnection(url);
            stml = conn.createStatement();
            String sql = "select * from T_book";
            ResultSet rs = stml.executeQuery(sql);
            User user = null;
            while(rs.next()){
                user = new User();
                user.setName(rs.getString("name"));
                user.setAddress(rs.getString("address"));
                user.setPicture(rs.getString("picture"));
                user.setInformation(rs.getString("information"));
                collection.add(user);
            }
        } catch (SQLException e) {
            System.out.println("数据库操作错误!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (stml != null) {
                try {
                    stml.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



