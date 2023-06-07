package validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("espaciosEnBlancoValidator")
public class espaciosenblancovalidador implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String cadena = (String) value;
        
        if (cadena != null && cadena.trim().isEmpty()) {
            throw new ValidatorException(new FacesMessage("La cadena no puede estar compuesta solo por espacios en blanco."));
        }
    }
}
