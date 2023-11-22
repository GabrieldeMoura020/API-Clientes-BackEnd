package br.com.senac.api.mappers;

import br.com.senac.api.dto.ClientesRequest;
import br.com.senac.api.dto.ClientesResponse;
import br.com.senac.api.dto.EnderecosRequest;
import br.com.senac.api.dto.EnderecosResponse;
import br.com.senac.api.entidades.Clientes;
import br.com.senac.api.entidades.Enderecos;

import java.util.ArrayList;
import java.util.List;

public class ClientesMapper {

    public static Clientes clientesRequestToClientes(ClientesRequest clientes){
        Clientes out = new Clientes();
        out.setEmail(clientes.getEmail());
        out.setTelefone(clientes.getTelefone());
        out.setNome(clientes.getNome());
        out.setSobreNome(clientes.getSobreNome());
        out.setDataNascimento(clientes.getDataNascimento());

        List<Enderecos> enderecosList = clientes.getEnderecos().stream().map(EnderecosMapper :: enderecosRequestToEnderecos).toList();

        out.setEnderecos(enderecosList);

        return out;
    }

    public static ClientesResponse clientesToClientesResponse(Clientes clientes){
        ClientesResponse out = new ClientesResponse();
        out.setEmail(clientes.getEmail());
        out.setTelefone(clientes.getTelefone());
        out.setNome(clientes.getNome());
        out.setSobreNome(clientes.getSobreNome());
        out.setDataNascimento(clientes.getDataNascimento());

        List<EnderecosResponse> enderecosResponseList = clientes.getEnderecos().stream().map(EnderecosMapper :: enderecosToEnderecosResponse).toList();

        out.setEnderecos(enderecosResponseList);

        return out;
    }
}
