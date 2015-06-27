package io.enscene.topophone;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;

//@WebServlet(name = "main", urlPatterns = {"/index.html", Servlet.APPLICATION_CONTEXT + "/*"},loadOnStartup=1)
public class Servlet extends HttpServlet {

  private static final long serialVersionUID = 1920434567655483949L;
  public static final String APPLICATION_CONTEXT = "/appli";

  @Override
  public void init() throws ServletException {
    // TODO Auto-generated method stub
    super.init();
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    // TODO Auto-generated method stub
    super.init(config);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    if (req.getHeader(HttpHeaders.ACCEPT).contains("text/html")) {
      req.getRequestDispatcher("/html/index").forward(req, resp);
    }
  }

}
