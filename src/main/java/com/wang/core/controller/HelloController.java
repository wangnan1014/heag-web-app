package com.wang.core.controller;

import com.wang.core.entity.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;


/**
 * Created by Administrator on 2017/6/12.
 */
@Controller
@RequestMapping("/wn")
public class HelloController {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String sayFirst(Model model){
        model.addAttribute("message","login");
        return "login";
    }

    @RequestMapping(value = "/hello",method =RequestMethod.GET)
    public String say(Model model){
        model.addAttribute("message","hello1");

        return "login";
    }
    @RequestMapping(value = "/{id}",method =RequestMethod.GET)
    public String sayID(Model model, @PathVariable("id") int id){
        model.addAttribute("message","hello12");
        return "login";
    }
    @RequestMapping(value = "/go/{str}/{message}",method =RequestMethod.GET)
    public String sayStr(Model model, @PathVariable("str") String str,@PathVariable String message ,@MatrixVariable(name="q",pathVar = "message") String q){
        model.addAttribute("str-q:"+q +"~"+message);
        return "login";
            //return "redirect:/wn/hello";
    }
    //只有当请求头中 Content-Type 的值与指定可消费的媒体类型中有相同的时候，请求才会被匹配
    @RequestMapping(path = "/pets", method = RequestMethod.POST, consumes="application/json")
    public void addPet(@RequestBody String pet, Model model) {
        // 方法实现省略
    }
    @RequestMapping(path = "/pets/{petId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getPet(@PathVariable String petId, Model model) {
        return petId;
        // 方法实现省略
    }
    //使用@RequestParam注解将请求参数绑定到你控制器的方法参数上
    //若参数使用了该注解，则该参数默认是必须提供的，但你也可以把该参数标注为非必须的：
    //只需要将@RequestParam注解的required属性设置为false即可（比如，@RequestParam(path="id", required=false)）。
    // 若所注解的方法参数类型不是String，则类型转换会自动地发生。
    //若@RequestParam注解的参数类型是Map<String, String>或者MultiValueMap<String, String>，则该Map中会自动填充所有的请求参数
    @RequestMapping(path = "/pets",method = RequestMethod.GET)
    public String setupForm(@RequestParam("petId") int petId, ModelMap model) {
        String pet = "";
        model.addAttribute("pet", pet);
        return "petForm";
    }
    @RequestMapping(path = "/something", method = RequestMethod.PUT)
    public void handle(@RequestBody String body, Writer writer) throws IOException {
        writer.write(body);
    }
    @RequestMapping(path = "/owners/{petId}/edit", method = RequestMethod.GET)
    public String processSubmit(@ModelAttribute("pet") String pet, BindingResult result) {
        if (result.hasErrors()) {
            return "petForm";
        }else{
            return "login";

        }
    }
    @RequestMapping(path="/wwww")
    public String testPost(ArrayList<User> user, Model model){
        return "login";
    }
    @RequestMapping(path="/goUpload")
    public String gotoUpload(){
        return "upload";
    }
    @RequestMapping(path="/upload",method = RequestMethod.POST,produces = "text/html;charset=Utf8")
    @ResponseBody
    public String upload(@RequestParam("name") String name,@RequestParam("file") MultipartFile[] file) throws IOException {
        String reStr="";
        for(MultipartFile f:file){
            if(!f.isEmpty()){
                InputStream is = f.getInputStream();
                reStr+=f.getOriginalFilename()+";";
            }
        }
        return "<font color='red'>"+reStr+"</font><a href=\"http://www.baidu.com\">www.baidu.com</a><a href='goUpload'>再次上传sdfds</a>";
    }

    @RequestMapping(path="/modelview")
    @ResponseBody
    public ModelAndView mode() throws IOException {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("login");
        return mav ;
    }
}
