package org.example.clientsideapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ClientController {
  @Autowired
  private StudentService studentService;


    @GetMapping("/client")
    public Map<String, Object> getStudentDetails(){
   return studentService.getStudentDetails();
    }
}
