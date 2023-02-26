package com.helloboot.helloboot;

import com.helloboot.helloboot.controller.IndexController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApiControllerTest {
    @Test
    void IndexControllerTest() {
        IndexController controller = new IndexController(name -> name);

        String ret = controller.hello("Test");

        Assertions.assertThat(ret).isEqualTo("Test");
    }

    @Test
    void failIndexControllerTest() {
        IndexController controller = new IndexController(name -> name);

        //Null check
        Assertions.assertThatThrownBy(() -> {
            controller.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        //Blank check
        Assertions.assertThatThrownBy(() -> {
            controller.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
