package br.usjt.appprevisoes.controller;

import java.util.List;
//Out project
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
//In project
import br.usjt.appprevisoes.model.Previsao;
import br.usjt.appprevisoes.repository.PrevisoesRepository;

@Controller
public class PrevisoesController {
	
	@Autowired
	private PrevisoesRepository previsaoRepo;
	
	@GetMapping ("/previsoes")
	public ModelAndView listarPrevisoes () {
	//passe o nome da página ao construtor
	ModelAndView mv = new ModelAndView ("lista_previsoes");
	//Busque a coleção com o repositório
	List <Previsao> previsoes = previsaoRepo.findAll();
	//adicione a coleção ao objeto ModelAndView
	mv.addObject("previsoes", previsoes);
	//devolva o ModelAndView
	return mv;
	}

}
