package es.miw.upm.web.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class IncorporarTemaJSFBean {
	private String name = "Hola, desde Bean. OK!!!";

	public String getName() {
		return name;
	}

}
