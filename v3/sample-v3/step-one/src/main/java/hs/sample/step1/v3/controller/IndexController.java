package hs.sample.step1.v3.controller;

import hs.sample.step1.v3.domain.article.service.ArticleInquiryService.ArticleInquiryService;
import hs.sample.step1.v3.model.Article;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
public class IndexController {

    private final ArticleInquiryService articleInquiryService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/main")
    public ModelAndView main(Map<String, Object> model) {
        List<Article> articles = articleInquiryService.inquiryMock();
        model.put("articles", articles);
        System.out.println(model);
        return new ModelAndView("main", model);
    }
}
