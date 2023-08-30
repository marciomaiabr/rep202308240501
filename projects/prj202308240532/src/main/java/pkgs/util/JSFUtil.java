package pkgs.util;

import java.util.Iterator;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;

public class JSFUtil {

	public static void listRequestParameters() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
		Iterator<String> iter = paramMap.keySet().iterator();
		while (iter.hasNext()) {
			String paramKey = (String) iter.next();
			System.out.println("paramKey = " + paramKey + " value = " + paramMap.get(paramKey).toString());
		}
	}

	public static String buscaRequestParameterFormPrincipal(String parameterName) {
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getExternalContext().getRequestParameterMap().get("formPrincipal:".concat(parameterName));
	}

	public static String buscaRequestParameter(String parameterName) {
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getExternalContext().getRequestParameterMap().get(parameterName);
	}

	public static Object buscaRequestAttribute(String attributeName) {
		FacesContext context = FacesContext.getCurrentInstance();
		ServletRequest request = (ServletRequest) context.getExternalContext().getRequest();
		return request.getAttribute(attributeName);
	}

}
