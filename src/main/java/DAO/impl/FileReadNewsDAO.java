package DAO.impl;

import DAO.NewsDAO;
import DAO.exception.DAOException;
import beans.Category;
import beans.News;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark_Harbunou on 1/30/2017.
 */
public class FileReadNewsDAO implements NewsDAO {
    Path pathToFile = Paths.get("C:/Users/Mark_Harbunou/IdeaProjects/NewsProtal1/NEWS.txt");
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    /*
        @Override
        public void addNews(News news) throws DAOException {
            try (FileWriter fileWriter = new FileWriter(String.valueOf(pathToFile), true)) {
                fileWriter.write(String.valueOf(news.getCategory()) + " " + news.getTitle() + " " + news.getAuthor() + "\n");
            } catch (IOException | NullPointerException | IllegalArgumentException e) {
                throw new DAOException();
            }
        }
    */
    @Override
    public void addNews(News news) throws DAOException {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewsPortal?useSSL=false", "root", "root");
          /*  str = conn.prepareStatement("INSERT INTO news VALUES (?,?,?);");
*/
            st = conn.createStatement();
            String query = "INSERT INTO NEWS VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, news.getCategory().toString());
            ps.setString(2, news.getTitle());
            ps.setString(3, news.getAuthor());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    @Override
    public String findNews(News news) throws DAOException {
        // ArrayList<String> findedNews = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewsPortal?useSSL=false", "root", "root");
            st = conn.createStatement();
            String query = "SELECT * FROM news WHERE Category = ? AND Title = ? AND Author = ?";
            PreparedStatement ps = conn.prepareStatement(query);
          ps.setString(1, news.getCategory().toString());
            ps.setString(2, news.getTitle());
            ps.setString(3, news.getAuthor());
            System.out.print(ps.toString());
            ps.executeQuery();
            return String.valueOf(ps.executeQuery());
            //findedNews.add((String.valueOf(news.getCategory())) + " " + news.getTitle() + " " + news.getAuthor());

        } catch (SQLException e) {
            throw new DAOException();
        }
    }
/*
    @Override
    public String findNews(News news) throws DAOException {
        // ArrayList<String> findedNews = new ArrayList<>();
        try {
            for (String line : Files.readAllLines(pathToFile, StandardCharsets.UTF_8)) {
                String[] argumentInTxt = line.split(" ");
                if (argumentInTxt[0].equalsIgnoreCase((news.getCategory().toString())) &&
                        argumentInTxt[1].equalsIgnoreCase(news.getTitle()) &&
                        argumentInTxt[2].equalsIgnoreCase(news.getAuthor())) {
                    return line;
                    //findedNews.add((String.valueOf(news.getCategory())) + " " + news.getTitle() + " " + news.getAuthor());
                }
            }
        } catch (IOException | NullPointerException | IllegalArgumentException e) {
            throw new DAOException();
        }
        throw new DAOException();
    }
*/
/*
    @Override
    public ArrayList<String> findNewsCategory(Category category) {
        ArrayList<String> addedNews = new ArrayList<>();
        Path pathToFile = Paths.get("C:/Users/Mark_Harbunou/IdeaProjects/NewsProtal1/NEWS.txt");
        try {
            List<String> lines = Files.readAllLines(pathToFile, StandardCharsets.UTF_8);
           for(String line :lines) {
               String[] argumentInTxt = line.split(" ");
               if(argumentInTxt[0].equals(category)) {
                   addedNews.add(line);
               }
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void findNewsTitle(String title) {

    }

    @Override
    public void findNewsAuthor(String author) {

    }
    */
}
