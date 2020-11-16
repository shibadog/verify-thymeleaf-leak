package jp.shibadog.sample.thymeleafleak;

import java.util.UUID;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class DemoController {

    private final ApplicationContext ctx;

    public DemoController(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String requestMethodName() {
        return "redirect:/hoge/" + UUID.randomUUID().toString();
    }

    @RequestMapping(value="/hoge/{uuid}", method=RequestMethod.GET)
    public String requestMethodName(@PathVariable String uuid, Model model) {
        System.out.println(ctx.getAutowireCapableBeanFactory().containsBean("redirect:/hoge/" + uuid));
        model.addAttribute("uuid", uuid);
        return "/redirect";
    }

}
