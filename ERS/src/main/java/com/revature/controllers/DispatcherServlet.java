package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {

	private Logger log = Logger.getRootLogger();
	private AppUserController auc = new AppUserController();
	private ReimbursementController rc = new ReimbursementController();

	@Override
	  protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.trace("DispatcherServlet.doOptions");
		resp.addHeader("Content-Type", "application/json");
        resp.addHeader("MIME", "application/json");
        resp.addHeader("Access-Control-Allow-Origin" , "http://localhost:3000");
        resp.addHeader("Access-Control-Allow-Credentials" , "true");
        resp.addHeader("Access-Control-Allow-Methods","POST,PUT");
        super.doOptions(req, resp);
    }
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		resp.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS");
		resp.addHeader("Access-Control-Allow-Headers",
				"Origin, Methods, Credentials, X-Requested-With, Content-Type, Accept");
		resp.addHeader("Access-Control-Allow-Credentials", "true");
		resp.setContentType("application/json");

		String uri = req.getRequestURI();
		String context = "ERS";
		String method = req.getMethod();
		uri = uri.substring(context.length() + 2, uri.length());
		log.debug(method + " request made with uri: " + uri);
		if ("OPTIONS".equals(method)) {
			doOptions(req, resp);
		}

		// if the request is not sending or prepared to recieve JSON objects, send an
		// error code
//		if (!"application/json".equals(req.getContentType())) {
//			resp.setStatus(406);
//			return;
//		}

		if (uri.startsWith("users")) {
			auc.process(req, resp);
		} else if (uri.startsWith("reimbs")) {
			rc.process(req, resp);
		} else if (uri.startsWith("test")) {
			resp.getWriter().write("test");
		} else {
			resp.setStatus(404);
			return;
		}

	}
}
