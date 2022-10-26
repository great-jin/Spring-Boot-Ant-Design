package xyz.ibudai.controller;

import org.springframework.web.bind.annotation.*;
import xyz.ibudai.entity.Student;

@RestController
@RequestMapping("api/axios")
public class AxiosController {

    /**
     * Get request demo
     */
    @GetMapping("get1")
    public String get1(String id) {
        System.out.println(id);
        return id;
    }

    @GetMapping("get2")
    public String get2(@RequestParam(value = "id") String id) {
        System.out.println(id);
        return id;
    }

    @GetMapping("get3")
    public String get3(@RequestParam(value = "id") String id,
                       @RequestParam(value = "message") String msg) {
        System.out.println(id + "_" + msg);
        return id + "_" + msg;
    }

    @GetMapping("get4")
    public String get4(Student student) {
        System.out.println(student);
        return student.toString();
    }

    @GetMapping("get5")
    public String get5(@RequestBody Student student) {
        System.out.println(student);
        return student.toString();
    }

    @GetMapping("get6")
    public String get6(@RequestParam(value = "id") String id,
                       @RequestBody Student student) {
        System.out.println(id + "_" + student);
        return id + "_" + student;
    }

    /**
     * Post request demo
     */
    @PostMapping("post1")
    public String post1(String id) {
        System.out.println(id);
        return id;
    }

    @PostMapping("post2")
    public String post2(@RequestParam(value = "id") String id) {
        System.out.println(id);
        return id;
    }

    @PostMapping("post3")
    public String post3(@RequestParam(value = "id") String id,
                        @RequestParam(value = "message") String msg) {
        System.out.println(id + "_" + msg);
        return id + "_" + msg;
    }

    @PostMapping("post4")
    public String post4(Student student) {
        System.out.println(student);
        return student.toString();
    }

    @PostMapping("post5")
    public String post5(@RequestBody Student student) {
        System.out.println(student);
        return student.toString();
    }
}
