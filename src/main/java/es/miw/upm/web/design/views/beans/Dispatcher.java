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
			System.out.println("votar get");
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
			System.out.println("El tag: "+request.getParameter("tag"));
			
			if (Integer.valueOf(request.getParameter("tag")) ==1 ){
				if(Integer.valueOf(request.getParameter("tema")) != null) {
					votarView.getTema().setIdTema(Integer.valueOf(request.getParameter("tema")));
					votarView.setId(Integer.valueOf(request.getParameter("tema")));
					request.setAttribute(action, votarView);
					view = votarView.process();
				}
			}
			if (Integer.valueOf(request.getParameter("tag")) == 2) {
				votarView.setId(Integer.valueOf(request.getParameter("id")));
				System.out.println("votar");
				voto = new Voto();
				voto.setIp(request.getParameter("ip"));
				voto.setNivelEstudiosType(NivelEstudiosType.valueOf(request
						.getParameter("nivel")));
				voto.setValor(Integer.valueOf(request.getParameter("valor")));
				votarView.setVoto(voto);
				request.setAttribute(action, votarView);
				view = votarView.process();

			}
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
			if (request.getParameter("flag")=="noAuth") {
				eliminarTemaView.setCodigo(request.getParameter("codigo"));
				view = eliminarTemaView.process();
			} else if (request.getParameter("flag")=="Auth") {
				eliminarTemaView.setIdtema(Integer.valueOf(request
						.getParameter("tema")));
				eliminarTemaView.setFlag("2");
				view = eliminarTemaView.eliminar();
			}
			request.setAttribute(action, eliminarTemaView);
			
			break;
		}

		this.getServletContext()
		.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
		.forward(request, response);
	}

}
