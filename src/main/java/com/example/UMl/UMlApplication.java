package com.example.UMl;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.UMl.Domain.Categoria;
import com.example.UMl.Domain.Cidade;
import com.example.UMl.Domain.Cliente;
import com.example.UMl.Domain.Endereco;
import com.example.UMl.Domain.Estado;
import com.example.UMl.Domain.ItemPedido;
import com.example.UMl.Domain.Pagamento;
import com.example.UMl.Domain.PagamentoComBoleto;
import com.example.UMl.Domain.PagamentoComCartao;
import com.example.UMl.Domain.Pedido;
import com.example.UMl.Domain.Produto;
import com.example.UMl.enums.EstadoPagamento;
import com.example.UMl.enums.TipoClient;
import com.example.UMl.repositories.CategoriaRepository;
import com.example.UMl.repositories.CidadeRepository;
import com.example.UMl.repositories.ClienteRepository;
import com.example.UMl.repositories.EnderecoRepository;
import com.example.UMl.repositories.EstadoRepository;
import com.example.UMl.repositories.ItemPedidoRepository;
import com.example.UMl.repositories.PagamentoRepository;
import com.example.UMl.repositories.PedidoRepository;
import com.example.UMl.repositories.ProdutoRepository;

@SpringBootApplication
public class UMlApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private  PedidoRepository pedidoRepository;
	@Autowired
	private  PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository  itemPedidoRepository;
	public static void main(String[] args) {
		SpringApplication.run(UMlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produto p1 = new  Produto(null, "Computador", 200.00);
		Produto p2 = new  Produto(null, "Impressora", 800.00);
		Produto p3 = new  Produto(null, "Mouse", 80.00);


		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));




		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));

		Cliente cli1 = new Cliente( null, "Maria Silva", "maria@email.com", "123132131213", TipoClient.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("8758411155", "4481855151"));

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "APT 303", "Jardim", "38855541", cli1, c1);
		Endereco e2 = new Endereco(null, "Av Mattos", "100", "SALA 800", "Centro", "45454114787", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2)); //

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
		Pedido pd1 = new  Pedido(null, sdf.parse("30/09/2017 10:32"),cli1, e1);
		Pedido pd2 = new  Pedido(null, sdf.parse("10/10/2017 10:32"),cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO,pd1, 6);
		pd1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE,pd2, sdf.parse("10/10/2017 10:32"),null);
		pd2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(pd1,pd2));

		pedidoRepository.saveAll(Arrays.asList(pd1,pd2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));

		ItemPedido ip1 = new ItemPedido(pd1,p1,0.00,1,2.000);
		ItemPedido ip2 = new ItemPedido(pd1,p3,0.00,2,80.00);
		ItemPedido ip3 = new ItemPedido(pd2,p2,100.00,1,800.000);

		pd1.getItems().addAll(Arrays.asList(ip1,ip2));
		pd2.getItems().addAll(Arrays.asList(ip3));

		p1.getitens().addAll(Arrays.asList(ip1));
		p2.getitens().addAll(Arrays.asList(ip3));
		p3.getitens().addAll(Arrays.asList(ip2));


		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));

	}

}
