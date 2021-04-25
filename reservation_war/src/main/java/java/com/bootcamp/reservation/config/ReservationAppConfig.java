package java.com.bootcamp.reservation.config;

import com.bootcamp.reservation.repository.FakeReservationRepository;
import com.bootcamp.reservation.repository.ReservationRepository;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextListener;
import java.com.bootcamp.reservation.listener.CustomListener;
import java.com.bootcamp.reservation.servlet.CustomServlet;

@Configuration
public class ReservationAppConfig {

    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> customListenerBean() {
        ServletListenerRegistrationBean<ServletContextListener> bean = new ServletListenerRegistrationBean();
        bean.setListener(new CustomListener());
        return bean;
    }

    @Bean
    public ReservationRepository reservationRepository() {
        return new FakeReservationRepository();
    }

    @Bean
    public ServletRegistrationBean customServletBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new CustomServlet(), "/servlet");
        return bean;
    }
}
