package br.com.sinergia.Controller;

import br.com.sinergia.Entity.Endereco;
import br.com.sinergia.Service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoCtrl {

    @Autowired
    private EnderecoService enderecoService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Endereco> getAllEndereco() {
        try {
            return enderecoService.getAllEndereco();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Endereco getEnderecoByID(@PathVariable("id") int id) {
        try {
            return enderecoService.getEnderecoByCod(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/busca_nome/{nome}", method = RequestMethod.GET)
    public List<Endereco> getEnderecoByName(@PathVariable("nome") String nome) {
        try {
            return enderecoService.getEnderecoByName(nome);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
