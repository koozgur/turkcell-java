package com.turkcell.spring.starter.controllers;


import com.turkcell.spring.starter.Request;
import com.turkcell.spring.starter.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/example")  //only manages the request coming as that path
public class ExampleController {

    @GetMapping //takes the incoming request mapping, forwarding it to that function
    public String get(@RequestParam("abc") String name) {
        return "Hello " + name; //returns back as response to requester(initial sender)
    }
/*
    @PostMapping
    public String c(@RequestBody int number){
        return "Initial post mapping called with: " + number;
    }
    //you cannot make 2 PostMapping with same path (same rules with get, also same goes to put and delete).
 */

    @PostMapping
    public Response d(@RequestBody Request request){
        Response response = new Response();
        response.setGivenNumber(request.getNumber());
        return response;   //this return object will be converted to JSON object.
    }
    //@PutMapping
    //@DeleteMapping
    @GetMapping("get")
    public String a(){
        return "Hello2";
    }
    @GetMapping("{page}")
    public  String b(@PathVariable String page){ //function will take any additional path value
        return "Page variable: " + page;
    }
    //if we make parameter type String and run with .../get, then a() function will be called, not that one


    //Initially it will take all values as String from path, (if function requires, it will try to convert to other types)
    //then it will try to find possible function to call, if there are multiple possible functions corresponding to the given query, we will get runtime error
    //which says "Ambitious handler"
    //run-time errors are different than compile-time errors.


}
