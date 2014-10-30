package eventmanager.presentation.controllers.impl;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eventmanager.integration.EventsServices;
import eventmanager.integration.bean.EventBean;
import eventmanager.integration.bean.ParticipantBean;
import eventmanager.integration.impl.EventsServicesImpl;
import eventmanager.presentation.controllers.AbstractController;
import eventmanager.presentation.utils.Constants;
import eventmanager.presentation.utils.HttpMethod;

/**
 * @author Hadrien
 * 
 */
/**
 * Servlet implementation class EventController
 */
@WebServlet("/Event/*")
public class EventController extends AbstractController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see AbstractController#AbstractController()
     */
    public EventController() {
        super();
        // TODO Auto-generated constructor stub
    }



	/* (non-Javadoc)
	 * @see eventmanager.presentation.controllers.AbstractController#process(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, eventmanager.presentation.utils.HttpMethod)
	 */
	@SuppressWarnings("deprecation")
	@Override
	protected void process(HttpServletRequest request, HttpServletResponse response, HttpMethod method)	throws ServletException, IOException {

		
		String[] parameters = request.getPathInfo().split("/");
		String eventId = parameters.length > 1 ? parameters[1] : null;
		
		EventsServices eServices = new EventsServicesImpl();
		EventBean eventBean = new EventBean();
		
		/*try {
			eventBean = eServices.getEventByUrl(new URL(eventId));
		} catch (Exception e) {
			e.printStackTrace();*/
			eventBean.setId(Integer.parseInt(eventId));
			eventBean.setNom("Java Dev Conf�rence");
			eventBean.setDescription("Conf�rence autour de Java 8 et des technologies associ�es");
			eventBean.setDatedeb(new Date(2014,10,29,8,15));
			eventBean.setDatefin(new Date(2014,10,30,20,30));
			eventBean.setAdresse("Centre des congr�s de Nantes - 44000 Nantes");
		//}
				
		request.setAttribute("event", eventBean);
		request.setAttribute("eventId", Long.parseLong(eventId));
		request.setAttribute("eventurl", request.getRequestURL());
		
		
		if(method==HttpMethod.POST) {
			
			String nom = request.getParameter("nom");	
			String prenom = request.getParameter("prenom");	
			String email = request.getParameter("email");	
			String societe = request.getParameter("societe");	
			
			try{
				
				ParticipantBean participantBean = new ParticipantBean();
				participantBean.setNom(nom);
				participantBean.setPrenom(prenom);
				participantBean.setEmail(email);
				participantBean.setSociete(societe);
				
				boolean registered = true;//eServices.registerParticipant(eventBean, participantBean);
				
				request.setAttribute("registered", registered);
				
				if(!registered) {
					request.setAttribute("alreadyRegistered", true);
				}
				
				HttpSession session = request.getSession(true);
				@SuppressWarnings("unchecked")
				TreeMap<Long, Boolean> participationMap = (TreeMap<Long, Boolean>)session.getAttribute("participateToEvent");
				if(participationMap==null)
				{
					participationMap = new TreeMap<Long, Boolean>();
				}
				participationMap.put(Long.parseLong(eventId), true);
				session.setAttribute("participateToEvent", participationMap);
				
				
			}catch(Exception ex) {
				request.setAttribute("errorOccured", true);
			}
		}
		
		showEventPage(request, response);
		
	}
	
	private void showEventPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = this.context.getRequestDispatcher(Constants.JSP_EVENT);	
		rd.include(request, response);
	}

}
