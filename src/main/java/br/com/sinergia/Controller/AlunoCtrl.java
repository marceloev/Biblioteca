package br.com.sinergia.Controller;

import br.com.sinergia.Entity.Aluno;
import br.com.sinergia.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoCtrl {

    @Autowired
    private AlunoService alunoService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Aluno> getAllAlunos() {
        try {
            return alunoService.getAllAlunos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Aluno getAlunoByCodigo(@PathVariable("id") int id) {
        try {
            return alunoService.getAlunoByCodigo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/matricula/{matricula}", method = RequestMethod.GET)
    public Aluno getAlunoByMatricula(@PathVariable("matricula") String matricula) {
        try {
            return alunoService.getAlunoByMatricula(matricula);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/busca_nome/{nome}", method = RequestMethod.GET)
    public List<Aluno> getAlunoByNome(@PathVariable("nome") String nome) {
        try {
            return alunoService.getAlunoByName(nome);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
