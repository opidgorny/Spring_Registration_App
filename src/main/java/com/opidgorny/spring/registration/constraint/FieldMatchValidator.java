package com.opidgorny.spring.registration.constraint;

import org.apache.commons.beanutils.BeanUtils;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(final FieldMatch fieldMatch) {
        firstFieldName = fieldMatch.first();
        secondFieldName = fieldMatch.second();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext validatorContext) {
        try {
            final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
            final Object secondObj = BeanUtils.getProperty(value, secondFieldName);
            return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        } catch (final Exception ignore) {}

        return true;
    }
}