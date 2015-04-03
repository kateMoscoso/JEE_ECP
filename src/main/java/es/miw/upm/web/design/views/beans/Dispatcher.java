package es.miw.upm.web.design.views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.miw.upm.persistence.model.utils.NivelEstudiosType;
import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.persistence.models.entities.Voto;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/views/jsp/";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getPathInfo().substring(1);

		String view;
		switch (action) {
		case "votar":
			VotarView votarView = new VotarView();
			request.setAttribute(action, votarView);
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
		this.getServletContext()
		.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
		.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		String view = "home";
		Tema tema;
		Voto voto;
		switch (action) {
		case "votar":
			VotarView votarView = new VotarView();			
			if (Integer.valueOf(request.getParameter("tag")) ==1 ){
				if(Integer.valueOf(request.getParameter("tema")) != null) {
					votarView.setId(Integer.valueOf(request.getParameter("tema")));
					request.setAttribute(action, votarView);
					view = votarView.obtenerDatosTema();
				}
			}
			if (Integer.valueOf(request.getParameter("tag")) == 2) {
				votarView.setId(Integer.valueOf(request.getParameter("id")));
				voto = new Voto(request.getRemoteAddr(),NivelEstudiosType.valueOf(request
						.getParameter("nivel")),Integer.valueOf(request.getParameter("valor")));
				votarView.setVoto(voto);
				request.setAttribute(action, votarView);
				view = votarView.votarTema();
			}
			break;
		case "incorporarTema":
			IncorporarTemaView incorporarTemaView = new IncorporarTemaView();
			tema = new Tema(request.getParameter("nombre"),request.getParameter("pregunta"));
			incorporarTemaView.setTema(tema);
			request.setAttribute(action, incorporarTemaView);
			view = incorporarTemaView.process();
			break;
		case "eliminarTema":
			EliminarTemaView eliminarTemaView = new EliminarTemaView();
			if ("noAuth".equals(request.getParameter("flag"))) {
				eliminarTemaView.setCodigo(request.getParameter("codigo"));
				request.setAttribute(action, eliminarTemaView);
				view = eliminarTemaView.process();
			} else if ("Auth".equals(request.getParameter("flag"))) {
				eliminarTemaView.setIdtema(Integer.valueOf(request
						.getParameter("tema")));
				eliminarTemaView.setFlag("Auth");
				request.setAttribute(action, eliminarTemaView);
				view = eliminarTemaView.eliminar();
			}
			break;
		}
		this.getServletContext()
		.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
		.forward(request, response);
	}

}
