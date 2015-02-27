package io.enscene.topophone;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;

@WebServlet(name = "main", urlPatterns = {"/index.html", Servlet.APPLICATION_CONTEXT+"/*"})
public class Servlet extends HttpServlet {

  public static final String APPLICATION_CONTEXT = "/appli";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {
    if (req.getHeader(HttpHeaders.ACCEPT).contains("text/html,")) {
      req.getRequestDispatcher("/html/index").forward(req, resp);
    }
  }



}
