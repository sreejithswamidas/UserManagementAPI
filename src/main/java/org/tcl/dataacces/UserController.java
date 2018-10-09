package org.tcl.dataacces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@CrossOrigin
@RestController
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    public UserRepository userRepository;
    public static AtomicInteger counter=new AtomicInteger(1000);
    UserController(){

    }
    @CrossOrigin("*")
    @PostMapping(path="/add",consumes="application/json",produces = "application/json")
    public ResponseEntity addUser(@RequestBody User user){

       // user.setId(counter.incrementAndGet());
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @CrossOrigin("*")
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
    @CrossOrigin("*")
    @GetMapping(path = "/get{UserID}")
    public Optional <User> getOne(@RequestParam Integer UserID){
        return userRepository.findById(UserID);
    }
}
