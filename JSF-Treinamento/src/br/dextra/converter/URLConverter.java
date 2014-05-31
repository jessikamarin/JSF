package br.dextra.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import org.apache.commons.validator.routines.UrlValidator;

import br.dextra.modelo.URLBookmark;

@FacesConverter("br.dextra.URLConverter")
public class URLConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		String HTTP = "http://";
		StringBuilder url = new StringBuilder();

		// if not start with http://, then add it
		if (!value.startsWith(HTTP, 0)) {
			url.append(HTTP);
		}
		url.append(value);

		// use Apache common URL validator to validate URLS
		UrlValidator urlValidator = new UrlValidator();
		// if URL is invalid
		if (!urlValidator.isValid(url.toString())) {

			FacesMessage msg = new FacesMessage("Formato de URL invalido!.",
					"Siga o formato: http://aaa.com.br");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(msg);
		}

		URLBookmark urlBookmark = new URLBookmark(url.toString());

		return urlBookmark;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		return value.toString();

	}
}