package com.funfit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.funfit.bean.Batch;
import com.funfit.bean.Participants;
import com.funfit.service.BatchService;
import com.funfit.service.ParticipantsService;

@WebServlet("/ParticipantsController")
public class ParticipantsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ParticipantsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		List<Batch> lb = BatchService.getBatch();
		hs.setAttribute("batch", lb);
		if(request.getParameter("target").equals("addParticipant")) {
			RequestDispatcher rd = request.getRequestDispatcher("addParticipant.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("viewParticipants.jsp");
			List<Participants> lp = ParticipantsService.getParticipants();
			hs.setAttribute("participants", lp);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		List<Batch> lb = BatchService.getBatch();
		HttpSession hs = request.getSession();
		hs.setAttribute("batch", lb);
		
		Participants p = new Participants();
		p.setFname(request.getParameter("fname"));
		p.setLname(request.getParameter("lname"));
		p.setAge(Integer.parseInt(request.getParameter("age")));
		p.setPhoneNumer(request.getParameter("phoneNumber"));
		p.setBatchId(Integer.parseInt(request.getParameter("batchId")));
		
		response.setContentType("text/html");
		
		if(request.getParameter("update") != null) {
			p.setPartId(Integer.parseInt(request.getParameter("partId")));
			List<Participants> lp = ParticipantsService.updateParticipant(p);
			if(lp != null) {
				hs.setAttribute("participants", lp);
				pw.println("Participant updated successfully");
			} else {
				pw.println("Participant update unsuccessful");
			}
			RequestDispatcher rd = request.getRequestDispatcher("viewParticipants.jsp");
			rd.include(request, response);
		} else {
			pw.println(ParticipantsService.addParticipant(p));
			RequestDispatcher rd = request.getRequestDispatcher("addParticipant.jsp");
			rd.include(request, response);
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPut() called");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int partId = Integer.parseInt(req.getParameter("id"));
		PrintWriter pw = resp.getWriter();
		RequestDispatcher rd = req.getRequestDispatcher("viewParticipants.jsp");
		resp.setContentType("text/html");
		pw.println(ParticipantsService.deleteParticipant(partId));
		rd.include(req, resp);
	}
}
