package com.helloboot.configuration;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "com.helloboot.configuration.autoconfig.DispatcherServeltConfiguration"
                ,"com.helloboot.configuration.autoconfig.TomcatWebServerConfiguration"
        };
    }
}
