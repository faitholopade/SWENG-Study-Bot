package ie.tcd.scss.studybot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ie.tcd.scss.studybot.domain.AnswerFrom;
import ie.tcd.scss.studybot.domain.Modules;
import ie.tcd.scss.studybot.domain.PromptTo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@CrossOrigin(origins = "http://localhost:5173")
public class StudyBotController {


    @Value("${openai.model}")
    private String AiModel;

    @Value(("${openai.api.url}"))
    private String url;

    @Autowired
    private RestTemplate template;

    @GetMapping("/{module}")
    public String study(@PathVariable String module){
        String modulePrompt = "";
        switch (module.toLowerCase()) {
            case "networks":
                modulePrompt = Modules.NETWORKS;
                break;
            case "functional":
                modulePrompt = Modules.FUNCTIONAL;
                break;
            case "architecture":
                modulePrompt = Modules.ARCHITECTURE;
                break;
            case "sweng":
                modulePrompt = Modules.SWENG;
                break;
            default:
                return "Your url must match an existing module (networks, functional, architecture, sweng)";
        }
        PromptTo request = new PromptTo(AiModel, modulePrompt);
        AnswerFrom answer = template.postForObject(url, request, AnswerFrom.class);
        if(answer == null) {
            return "Null Response";
        }
        return answer.getChoices().get(0).getMessage().getContent();
    }
}