package com.unibrasil.sca.matricula;
import java.util.ArrayList;
import java.util.List;
 
public class ValidationErrorDTO {
 
    private List<ObjectErrorDTO> objectErrors = new ArrayList<>();
    
    public void addObjectError(String message) {
    	ObjectErrorDTO error = new ObjectErrorDTO(message);
    	objectErrors.add(error);
    }
 
	public List<ObjectErrorDTO> getObjectErrors() {
		return objectErrors;
	}

	public void setObjectErrors(List<ObjectErrorDTO> objectErrors) {
		this.objectErrors = objectErrors;
	}
 
    
}