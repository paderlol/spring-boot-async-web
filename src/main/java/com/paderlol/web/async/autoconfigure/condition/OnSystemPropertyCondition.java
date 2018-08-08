package com.paderlol.web.async.autoconfigure.condition;

import java.util.Map;
import java.util.Optional;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnSystemPropertyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata
                .getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        String name = annotationAttributes.getOrDefault("name", "jdkVersion").toString();

        return Optional.ofNullable(System.getProperty(name)).isPresent();
    }

}
