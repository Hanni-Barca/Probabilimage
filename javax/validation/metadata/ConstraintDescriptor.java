package javax.validation.metadata;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintValidator;
import javax.validation.Payload;

public interface ConstraintDescriptor<T extends Annotation> {
    T getAnnotation();

    Map<String, Object> getAttributes();

    Set<ConstraintDescriptor<?>> getComposingConstraints();

    List<Class<? extends ConstraintValidator<T, ?>>> getConstraintValidatorClasses();

    Set<Class<?>> getGroups();

    Set<Class<? extends Payload>> getPayload();

    boolean isReportAsSingleViolation();
}
