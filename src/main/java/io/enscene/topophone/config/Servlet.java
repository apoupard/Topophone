package io.enscene.topophone.config;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;

public class Servlet extends HttpServlet {

  public static final String APPLICATION_CONTEXT = "/appli";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    if (req.getHeader(HttpHeaders.ACCEPT).contains("text/html")) {
      req.getRequestDispatcher("/html/sections/index").forward(req, resp);
    }
  }

}
