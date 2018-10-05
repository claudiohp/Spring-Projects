package br.com.senac.inicializacao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.dominio.Aluno;
import br.com.senac.dominio.Categoria;
import br.com.senac.dominio.Cidade;
import br.com.senac.dominio.Curso;
import br.com.senac.dominio.Endereco;
import br.com.senac.dominio.Estado;
import br.com.senac.dominio.Pagamento;
import br.com.senac.dominio.PagamentoComBoleto;
import br.com.senac.dominio.Pedido;
import br.com.senac.dominio.enums.StatusPagamento;
import br.com.senac.repositorio.AlunoRepositorio;
import br.com.senac.repositorio.CategoriaRepositorio;
import br.com.senac.repositorio.CidadeRepositorio;
import br.com.senac.repositorio.CursoRepositorio;
import br.com.senac.repositorio.EnderecoRepositorio;
import br.com.senac.repositorio.EstadoRepositorio;
import br.com.senac.repositorio.PagamentoRepositorio;
import br.com.senac.repositorio.PedidoRepositorio;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	AlunoRepositorio alunorepositorio;

	@Autowired
	CidadeRepositorio cidaderepositorio;

	@Autowired
	EstadoRepositorio estadorepositorio;

	@Autowired
	EnderecoRepositorio enderecorepositorio;
	
	@Autowired
	PedidoRepositorio pedidorepositorio;
	
	@Autowired
	PagamentoRepositorio pagamentorepositorio;
	
	@Autowired
	CursoRepositorio cursorepositorio;
	
	@Autowired
	CategoriaRepositorio categoriarepositorio;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("Aplicação iniciada com sucesso.");
		
		Aluno alunoGravado = alunorepositorio.findByEmail("claudio.henriquepj@gmail.com");
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Claudio");
		aluno1.setEmail("claudio.henriquepj@gmail");

		Aluno aluno2 = new Aluno();
		aluno2.setNome("Jorge");

		Estado estado1 = new Estado();
		estado1.setNome("Rio de Janeiro");
		Estado estado2 = new Estado();
		estado2.setNome("São Paulo");

		Cidade cidade1 = new Cidade();
		cidade1.setNome("Rio de Janeiro");
		cidade1.setEstado(estado1);

		Cidade cidade2 = new Cidade();
		cidade2.setNome("Niteroi");
		cidade2.setEstado(estado1);

		Cidade cidade3 = new Cidade();
		cidade3.setNome("Mogi das Cruzes");
		cidade3.setEstado(estado2);

		Endereco end1 = new Endereco();
		end1.setLogradouro("Av. 28 de Setembro");
		end1.setNumero("20");
		end1.setBairro("Vila Isabel");
		end1.setComplemento("Bloco B");
		end1.setCep("20546-989");
		end1.setCidade(cidade1);
		end1.setAluno(aluno1);

		Endereco end2 = new Endereco();
		end2.setLogradouro("Rua dos Marrecos");
		end2.setNumero("68");
		end2.setBairro("Laje");
		end2.setComplemento("Fundos");
		end2.setCep("21467-700");
		end2.setCidade(cidade3);
		end2.setAluno(aluno2);

		alunorepositorio.save(aluno1);
		alunorepositorio.save(aluno2);
		estadorepositorio.saveAll(Arrays.asList(estado1, estado2));
		cidaderepositorio.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		enderecorepositorio.saveAll(Arrays.asList(end1, end2));

		Pedido ped1 = new Pedido();
		ped1.setAluno(aluno1);
		ped1.setEnderecoDeEntrega(end1);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");

		try {

			ped1.setDataPedido(sdf.parse("10/05/2018 10:35"));
			Pagamento pag1 = new PagamentoComBoleto(null, StatusPagamento.QUITADO, ped1, sdf.parse("15/05/2018 21:20"), sdf.parse("20/05/2018 15:34"));
			ped1.setPagamento(pag1);
			
			pedidorepositorio.save(ped1);
			
			pagamentorepositorio.save(pag1);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Categoria categoria1 = new Categoria();
		categoria1.setNome("Java");
		Categoria categoria2 = new Categoria();
		categoria2.setNome("Spring");
		
		
		Curso curso1 = new Curso();
		curso1.setNome("Java Web");
		curso1.setDescricao("Java web para alunos");
		curso1.setPreco(300.00);
		
		Curso curso2 = new Curso();
		curso2.setNome("Spring-MVC");
		curso2.setDescricao("Spring web para alunos");
		curso2.setPreco(400.00);
		
		HashSet<Categoria> categorias = new HashSet<Categoria>();
		categorias.add(categoria1);
		
		curso1.setCategorias(categorias);
		cursorepositorio.save(curso1);
		categoriarepositorio.save(categoria1);
		
	}

}
