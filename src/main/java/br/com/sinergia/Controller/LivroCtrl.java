package br.com.sinergia.Controller;

import br.com.sinergia.Entity.Livro;
import br.com.sinergia.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroCtrl {

    @Autowired
    private LivroService livroService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Livro> getAllLivros() {
        try {
            return livroService.getAllLivros();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Livro getLivroByCodigo(@PathVariable("id") int id) {
        try {
            return livroService.getLivroByCodigo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/busca_nome/{nome}", method = RequestMethod.GET)
    public List<Livro> getLivroByNome(@PathVariable("nome") String nome) {
        try {
            return livroService.getLivroByNome(nome);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
