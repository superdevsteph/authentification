package com.hellokoding.account.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hellokoding.account.model.Topo;
import com.hellokoding.account.service.TopoService;

@Component
public class TopoValidator implements Validator {
    @Autowired
    private TopoService topoService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Topo.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	Topo topo = (Topo) o;

    	   // Check the fields of TopoInfo.
        // (See more in property file: messages/validator.properties)
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "toponame", "NotEmpty.userForm.toponame");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "region", "NotEmpty.userForm.region");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nbSites", "NotEmpty.userForm.nbSites");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nbSecteurs", "NotEmpty.userForm.nbSecteurs");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nbVoies", "NotEmpty.userForm.nbVoies");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty.userForm.description");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "datePublication", "NotEmpty.userForm.datePublication");
 
    }
}
