package pl.alburnus.springws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
@ComponentScan("pl.alburnus.springws")
public class AppConfig extends WsConfigurerAdapter {
    // Bean name have influence to endpoint address TeamService.wsdl: http://localhost:8080/endpoints/TeamService.wsdl
    @Bean(name = "TeamService")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema teamSchemas) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("TeamService");
        wsdl11Definition.setLocationUri("/endpoints");
        wsdl11Definition.setTargetNamespace("http://pl/alburnus/springws/ws/team");
        wsdl11Definition.setSchema(teamSchemas);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema teamSchemas() {
        return new SimpleXsdSchema(new ClassPathResource("schemas/schema1.xsd"));
    }
}