package com.scaler.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class SampleController {

        @GetMapping("/hello/{name}/{times}")
        public String helloWorld(@PathVariable("name") String name, @PathVariable("times") int times) {
            String output = "";
            for (int i = 0; i < times; i++) {
                output = output + "Hello " + name + "! ";
            }
            return output;
        }

        @GetMapping("/good-bye")
        public String byeWorld(String timeofday) {
            return "Good bye!";
        }
}
