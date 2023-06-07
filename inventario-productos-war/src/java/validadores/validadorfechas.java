package validadores;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validadorfechas")
public class validadorfechas implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Date fechaProducto = (Date) value;
        Date fechaActual = new Date(); // Obtiene la fecha actual
        
        if (fechaProducto != null && fechaProducto.compareTo(fechaActual) >= 0) {
            throw new ValidatorException(new FacesMessage("La fecha del producto no puede ser igual o superior al día de hoy."));
        }
    }
}
