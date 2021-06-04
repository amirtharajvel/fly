package com.fly.controller;

import com.fly.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@CrossOrigin
public class FlyController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<String, Object>> getUrl(@RequestParam("sleeptime") Integer sleep, @RequestParam("error") Integer error) throws InterruptedException {

        if(error == 1) {
            throw new RuntimeException(("Hoola"));
        }

        Thread.sleep(sleep == null ? 1000 : sleep);
        HashMap<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        return ResponseEntity.ok(map);

    }

    @GetMapping(value = "/o")
    public @ResponseBody String action(@RequestParam("name") String name) {
        employeeService.lets(name);
        return "Success";
    }

    @GetMapping(value = "/s/{id}")
    public @ResponseBody String second(@PathVariable("id") Long id) {
        employeeService.second(id);
        return "Success";
    }
}
