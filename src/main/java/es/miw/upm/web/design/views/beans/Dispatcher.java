package es.miw.upm.web.design.views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

import es.miw.upm.persistence.model.utils.NivelEstudiosType;
import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.persistence.models.entities.Voto;



@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/views/";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo().substring(1);

		String view; 
		switch (action) {
		case "votar":
			VotarView votoView = new VotarView();
			request.setAttribute(action, votoView);
			view = action;
			break;
		case "verVotaciones":
			VerVotacionesView verVotacionesView = new VerVotacionesView();
			request.setAttribute(action, verVotacionesView);
			view = action;
			break;
		case "incorporarTema":
			IncorporarTemaView incorporarTemaView = new IncorporarTemaView();
			request.setAttribute(action, incorporarTemaView);
			view = action;
			break;
		case "eliminarTema":
			EliminarTemaView eliminarTemaView = new EliminarTemaView();
			request.setAttribute(action, eliminarTemaView);
			view = action;
			break;
		default:
			view = "home";
		}

		this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
		.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		String view = "home";
		Tema tema;
		Voto voto;
		switch (action) { 
		case "votar":
			System.out.println(request.getParameter("tema"));
//			voto = new Voto();
//			voto.setIp(request.getParameter("ip"));
//			voto.setNivelEstudiosType(NivelEstudiosType.valueOf(request.getParameter("nivel")));
//			voto.setValor(Integer.valueOf(request.getParameter("valor")));
			tema = new Tema();
			tema.setNombre(request.getParameter("tema"));
//			tema.setPregunta(request.getParameter("pregunta"));
			VotarView votarView = new VotarView();
//			votarView.setVoto(voto);
//			votarView.setTema(tema);
			request.setAttribute(action, votarView);
			
			view = votarView.process();
			break;
		case "incorporarTema":
			IncorporarTemaView incorporarTemaView = new IncorporarTemaView();
			tema = new Tema();
			tema.setNombre(request.getParameter("nombre"));
			tema.setPregunta(request.getParameter("pregunta"));
			incorporarTemaView.setTema(tema);
			request.setAttribute(action, incorporarTemaView);
			view = incorporarTemaView.process();
			break;
		case "eliminarTema":
			EliminarTemaView eliminarTemaView = new EliminarTemaView();
			tema = new Tema();
//			tema.setId_tema((Integer)(request.getParameter("id"));
			tema.setNombre(request.getParameter("nombre"));
			tema.setPregunta(request.getParameter("pregunta"));
			eliminarTemaView.setTema(tema);
//			incorporarTemaView.setTema(tema);
//			request.setAttribute(action, incorporarTemaView);
//			view = incorporarTemaView.process();
			break;
		}

		this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
		.forward(request, response);
	}

}
