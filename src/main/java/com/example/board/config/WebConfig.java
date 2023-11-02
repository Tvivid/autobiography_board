package com.example.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private String resourcePath= "/upload/**"; // view에서 접근할 경로
    private String savepath = "file:///C:\\Users\\tjsau\\Desktop\\code\\board_file\\"; //실제 파일 저장 경로

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler(resourcePath) //view에서 이 경로로 접근하면
                .addResourceLocations(savepath); //spring이 이 경로로 찾아준다
    }


}
