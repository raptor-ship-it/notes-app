package org.raptor.notes.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
@EnableConfigurationProperties(NoteProperties.class)
public class NoteConfig implements WebMvcConfigurer {
    @Autowired
    private NoteProperties noteProperties;

    public NoteConfig() {
        super();
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry ) {
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:"+noteProperties.getUploadDir())
                .setCachePeriod(3600)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());

        return;
    }


}
