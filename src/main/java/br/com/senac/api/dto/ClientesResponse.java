package br.com.senac.api.dto;

import java.time.LocalDate;
import java.util.List;

public class ClientesResponse {

    private Long id;
    private String nome;
    private String sobreNome;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;

    private List<EnderecosResponse> enderecos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<EnderecosResponse> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecosResponse> enderecos) {
        this.enderecos = enderecos;
    }
}
