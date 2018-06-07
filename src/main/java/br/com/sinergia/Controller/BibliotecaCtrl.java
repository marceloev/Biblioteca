package br.com.sinergia.Controller;

import br.com.sinergia.Entity.Biblioteca;
import br.com.sinergia.Service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bibliotecas")
public class BibliotecaCtrl {

    @Autowired
    private BibliotecaService bibliotecaService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Biblioteca> getAllBiblioteca() {
        try {
            return bibliotecaService.getAllBiblioteca();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Biblioteca getBibliotecaByCod(@PathVariable("id") int id) {
        try {
            return bibliotecaService.getBibliotecaByCod(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/busca_nome/{nome}", method = RequestMethod.GET)
    public List<Biblioteca> getBibliotecaByName(@PathVariable("nome") String nome) {
        try {
            return bibliotecaService.getBibliotecaByName(nome);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
