package br.com.gestorprev.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.gestorprev.data.vo.v1.PessoaV1;
import br.com.gestorprev.model.Pessoa;

public class MockPessoa {


    public Pessoa mockEntity() {
        return mockEntity();
    }
    
    public PessoaV1 mockVO() {
        return mockVO(0);
    }
    
    public List<Pessoa> mockEntityList() {
        List<Pessoa> persons = new ArrayList<Pessoa>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PessoaV1> mockVOList() {
        List<PessoaV1> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }
    
    public Pessoa mockEntity(Integer number) {
    	Pessoa pessoa = new Pessoa();
    	pessoa.setId(number.longValue());
    	pessoa.setCpf("34724772883" + number);
    	pessoa.setNome("Rodrigo Cicoti" + number);
    	pessoa.setRg("34126" + number);
        return pessoa;
    }

    public PessoaV1 mockVO(Integer number) {
    	PessoaV1 pessoa = new PessoaV1();
    	pessoa.setKey(number.longValue());
    	pessoa.setCpf("34724772883" + number);
    	pessoa.setNome("Rodrigo Cicoti" + number);
    	pessoa.setRgN("34126" + number);
        return pessoa;
    }

}
