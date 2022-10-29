package xyz.ibudai.controller;

import org.springframework.web.bind.annotation.*;
import xyz.ibudai.entity.Student;
import xyz.ibudai.entity.Teacher;

@RestController
@RequestMapping("api/axios")
public class AxiosController {

    /**
     * Get request demo
     */
    @GetMapping("get1")
    public String get1(String id) {
        return id;
    }

    @GetMapping("get2")
    public String get2(@RequestParam(value = "id") String id) {
        return id;
    }

    @GetMapping("get3")
    public String get3(@RequestParam(value = "id") String id,
                       @RequestParam(value = "message") String msg) {
        return id + "_" + msg;
    }

    @GetMapping("get4")
    public String get4(Student student) {
        return student.toString();
    }

    /**
     * Post request demo
     */
    @PostMapping("post1")
    public String post1(String id) {
        return id;
    }

    @PostMapping("post2")
    public String post2(@RequestParam(value = "id") String id) {
        return id;
    }

    @PostMapping("post3")
    public String post3(@RequestParam(value = "id") String id,
                        @RequestParam(value = "message") String msg) {
        return id + "_" + msg;
    }

    @PostMapping("post4")
    public String post4(Student student) {
        return student.toString();
    }

    @PostMapping("post5")
    public String post5(@RequestBody Student student) {
        return student.toString();
    }

    @PostMapping("post6")
    public String post6(String id, Teacher teacher) {
        return id + "_" + teacher.toString();
    }

    @PostMapping("post7")
    public String post7(Student student, Teacher teacher) {
        return student.toString() + "_" + teacher.toString();
    }
}
