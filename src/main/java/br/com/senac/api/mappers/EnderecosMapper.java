package br.com.senac.api.mappers;

import br.com.senac.api.dto.EnderecosRequest;
import br.com.senac.api.dto.EnderecosResponse;
import br.com.senac.api.entidades.Enderecos;

public class EnderecosMapper {

    public static Enderecos enderecosRequestToEnderecos(EnderecosRequest enderecos){
        Enderecos out = new Enderecos();
        out.setRua(enderecos.getRua());
        out.setBairro(enderecos.getBairro());
        out.setCidade(enderecos.getCidade());
        out.setEstado(enderecos.getEstado());

        return out;
    }

    public static EnderecosResponse enderecosToEnderecosResponse(Enderecos enderecos){
        EnderecosResponse out = new EnderecosResponse();
        out.setId(enderecos.getId());
        out.setRua(enderecos.getRua());
        out.setBairro(enderecos.getBairro());
        out.setCidade(enderecos.getCidade());
        out.setEstado(enderecos.getEstado());
    }
}
