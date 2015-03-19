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

	private static String PATH_ROOT_VIEW = "/views/";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

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
			System.out.println("Dispatcher el tag es: "
					+ request.getParameter("tag"));
			if (Integer.valueOf(request.getParameter("tag")) == 1) {
				votarView.setId(Integer.valueOf(request.getParameter("tema")));
				votarView.setFlag(1);
				request.setAttribute(action, votarView);
				view = votarView.process();
			} else if (Integer.valueOf(request.getParameter("tag")) == 2) {
				System.out.println("segunda parte");
				votarView.setFlag(Integer.valueOf(request.getParameter("tag")));
				votarView.setId(Integer.valueOf(request.getParameter("id")));
				voto = new Voto();
				voto.setIp(request.getParameter("ip"));
				System.out.println("la ip es: " + request.getParameter("ip"));
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
			System.out.println("eliminar - valor flag " + Integer.valueOf(request.getParameter("flag")));
			if (Integer.valueOf(request.getParameter("flag"))==1) {
				System.out.println("entra valor es 1");
				eliminarTemaView.setCodigo(request.getParameter("codigo"));

			} else if (Integer.valueOf(request.getParameter("flag"))==2) {
				System.out.println("entra valor es 2 " + Integer.valueOf(request
						.getParameter("tema")));
				eliminarTemaView.setIdtema(Integer.valueOf(request
						.getParameter("tema")));
				eliminarTemaView.setFlag(2);
			}
			request.setAttribute(action, eliminarTemaView);
			view = eliminarTemaView.process();
			break;
		}

		this.getServletContext()
		.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
		.forward(request, response);
	}

}
