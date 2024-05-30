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
import com.funfit.service.BatchService;

@WebServlet("/BatchController")
public class BatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BatchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Batch> lb = BatchService.getBatch();
		PrintWriter pw = response.getWriter();
		HttpSession hs = request.getSession();
		hs.setAttribute("batch", lb);

		RequestDispatcher rd = request.getRequestDispatcher("viewBatch.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		Batch bb = new Batch();
		bb.setTypeOfBatch(request.getParameter("typeOfBatch"));
		bb.setTime(request.getParameter("time"));
		
		response.setContentType("text/html");
		if(request.getParameter("update") != null) {
			bb.setBatchId(Integer.parseInt(request.getParameter("batchId")));
			RequestDispatcher rd = request.getRequestDispatcher("viewBatch.jsp");
			HttpSession hs = request.getSession();
			List<Batch> lb = BatchService.updateBatch(bb);
			if (lb != null) {
				hs.setAttribute("batch", lb);
				pw.println("Batch updated successfully.");
			} else {
				pw.println("Batch update unsuccessful");
			}
			rd.include(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("addBatch.jsp");
			
			pw.println(BatchService.addBatch(bb));
			rd.include(request, response);
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPut called");
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int batchId = Integer.parseInt(req.getParameter("id"));
		PrintWriter pw = resp.getWriter();
		RequestDispatcher rd = req.getRequestDispatcher("viewBatch.jsp");
		resp.setContentType("text/html");
		pw.println(BatchService.deleteBatch(batchId));
		rd.include(req, resp);
	}

}
