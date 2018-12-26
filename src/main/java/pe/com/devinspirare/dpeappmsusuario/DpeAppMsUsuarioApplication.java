package pe.com.devinspirare.dpeappmsusuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(value = {"pe.com.devinspirare.dpeappmsusuario.dao","pe.com.devinspirare.dpeappjarmodels"})
@EntityScan(value = "pe.com.devinspirare.dpeappjarmodels")
public class DpeAppMsUsuarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(DpeAppMsUsuarioApplication.class, args);
    }
}
