package br.com.gestorprev.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gestorprev.data.vo.v2.PessoaV2;
import br.com.gestorprev.data.vo.v1.PessoaV1;
import br.com.gestorprev.model.Pessoa;

@Service
public class PessoaMapper {
	//v1
	public PessoaV1 convertEntityToVoV1(Pessoa pessoa) {
		PessoaV1 vo = new PessoaV1();
		
		vo.setId(pessoa.getId());
		vo.setNome(pessoa.getNome());
		//vo.setIdSexo(pessoa.getIdSexo());
		vo.setCpf(pessoa.getCpf());
		vo.setRgN(pessoa.getRg() );
		return vo;
	}
	
    public List<PessoaV1> convertEntityToVoListV1(List<Pessoa> pessoas) {
        List<PessoaV1> voList = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            PessoaV1 vo = new PessoaV1();

            vo.setId(pessoa.getId());
            vo.setNome(pessoa.getNome());
            // vo.setIdSexo(pessoa.getIdSexo()); 
            vo.setCpf(pessoa.getCpf());
            vo.setRgN(pessoa.getRg()); 

            voList.add(vo); 
        }

        return voList; 
    }

	public Pessoa convertVoToEntityV1(PessoaV1 pessoa) {
		Pessoa entity = new Pessoa();
		entity.setId(pessoa.getId());
		entity.setNome(pessoa.getNome());
		//entity.setIdSexo(pessoa.getIdSexo());
		entity.setCpf(pessoa.getCpf());
		entity.setRg(pessoa.getRgN());
		return entity;
	}
	
	//v2
	public PessoaV2 convertEntityToVoV2(Pessoa pessoa) {
		PessoaV2 vo = new PessoaV2();
		
		vo.setId(pessoa.getId());
		vo.setNome(pessoa.getNome());
		vo.setIdSexo((long) 1);
		vo.setCpf(pessoa.getCpf());
		return vo;
	}
	
	public Pessoa convertVoToEntityV2(PessoaV2 pessoa) {
		Pessoa entity = new Pessoa();
		entity.setId(pessoa.getId());
		entity.setNome(pessoa.getNome());
		//entity.setIdSexo(pessoa.getIdSexo());
		entity.setCpf(pessoa.getCpf());
		return entity;
	}

}
