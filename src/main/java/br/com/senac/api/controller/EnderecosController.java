package br.com.senac.api.controller;

import br.com.senac.api.entidades.Enderecos;
import br.com.senac.api.repositorio.EnderecosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/enderecos")
public class EnderecosController {

    @Autowired
    private EnderecosRepository enderecosRepository;

    @GetMapping("/")
    @CrossOrigin
    public ResponseEntity<List<Enderecos>> carregarEnderecos(){
        List<Enderecos> retorno = enderecosRepository.findAll();
        return ResponseEntity.ok().body(retorno);
    }

    @PostMapping("/")
    public ResponseEntity<Enderecos> criarEnderecos(@RequestBody Enderecos enderecos){
        Enderecos retorno = enderecosRepository.save(enderecos);

        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEnderecos(@PathVariable Long id){
        enderecosRepository.deleteById(id);

        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Enderecos> atualizarEnderecos(@PathVariable Long id, @RequestBody Enderecos enderecos){
        Enderecos retorno = enderecosRepository.findById(id).map(record -> {
            record.setRua(enderecos.getRua());
            record.setBairro(enderecos.getBairro());
            record.setCidade(enderecos.getCidade());
            record.setEstado(enderecos.getEstado());
            return enderecosRepository.save(record);
        }).get();

        return ResponseEntity.ok(retorno);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Enderecos> carregarEnderecosById(@PathVariable Long id){
        Enderecos retorno = enderecosRepository.findById(id).get();
        return ResponseEntity.ok(retorno);
    }

    @GetMapping("/{endereco}/buscar")
    public ResponseEntity<List<Enderecos>> carregarEnderecosByRua(@PathVariable String rua){
        List<Enderecos> retorno = enderecosRepository.findByEndereco(rua);

        return ResponseEntity.ok(retorno);
    }
}
