package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spittr.data.SpittleRepository;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }


    @RequestMapping
    public String spittles(Model model) {
        model.addAttribute(spittleRepository.fineSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }
}
