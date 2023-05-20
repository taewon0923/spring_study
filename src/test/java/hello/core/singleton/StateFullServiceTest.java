package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


class StateFullServiceTest {

    @Test
    void stateFullServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFullService stateFullService1 = ac.getBean(StateFullService.class);
        StateFullService stateFullService2 = ac.getBean(StateFullService.class);

        int userAPrice = stateFullService1.order("userA", 10000);
        int userBPrice = stateFullService2.order("userB", 20000);

//        int price = stateFullService1.price();
        System.out.println("price = " + userAPrice);

//        Assertions.assertThat(stateFullService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{

        @Bean
        public StateFullService stateFullService(){
            return new StateFullService();
        }
    }

}