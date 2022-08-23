package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //정적 컨텐츠
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "spring!");
        return "hello";
    }
    //MVC 방식 (Model View Controller), 템플릿 엔진 이용용
   @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }
    //API 방식(HTTP의 BODY에 내용을 직접 반환, html X)
    @GetMapping("hello-string")
    @ResponseBody //http 통신규약 response body를 직접 설정해주겠다는 뜻
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    //API 방식(JSON형태로 객체를 반환)
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name= name;
        }
    }

}
