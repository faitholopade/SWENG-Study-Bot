package ie.tcd.scss.studybot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ie.tcd.scss.studybot.domain.AnswerFrom;
import ie.tcd.scss.studybot.domain.PromptTo;

@RestController
@RequestMapping()
public class StudyBotController {

    @Value("${openai.model}")
    private String AiModel;

    @Value(("${openai.api.url}"))
    private String url;

    @Autowired
    private RestTemplate template;

    @GetMapping("/study")
    public String chat(@RequestParam("prompt") String prompt){
        PromptTo request = new PromptTo(AiModel, prompt);
        AnswerFrom answer = template.postForObject(url, request, AnswerFrom.class);
        if(answer == null) {
            return "Null Response";
        }
        return answer.getChoices().get(0).getMessage().getContent();
    }
}