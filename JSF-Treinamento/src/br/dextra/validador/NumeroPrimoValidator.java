package br.dextra.validador;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("NumeroPrimoValidator")
public class NumeroPrimoValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object value)
			throws ValidatorException {
		long numero = (Long) value;
		boolean isPrimo = false;

		if (numero > 1) {
			double raizQuadrada = Math.sqrt((double) numero);
			isPrimo = true;
			for (long i = 2; i <= raizQuadrada; i++) {
				if (numero % i == 0) {
					isPrimo = false;
					break;
				}

			}

		}

		if (isPrimo) {
			FacesMessage mensagem = new FacesMessage("O número " + numero
					+ " é primo");
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(mensagem);

		} else {
			FacesMessage mensagem2 = new FacesMessage("O número " + numero
					+ " não é primo");
			mensagem2.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(mensagem2);
		}

	}

}
