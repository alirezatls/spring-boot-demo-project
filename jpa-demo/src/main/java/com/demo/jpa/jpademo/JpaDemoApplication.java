package com.demo.jpa.jpademo;

import com.demo.jpa.jpademo.entity.Product;
import com.demo.jpa.jpademo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private ProductRepository productRepository;

	@Autowired
	public JpaDemoApplication(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}



	public void init() {
		productRepository.save(new Product("java",100));
		productRepository.save(new Product("c#",1000));
		productRepository.save(new Product("python",1020));
		productRepository.save(new Product("spring",10));
		productRepository.save(new Product("go",320));
		productRepository.save(new Product("php",10000));
		productRepository.save(new Product("hibernate",66));
		productRepository.save(new Product("elxir",21));
		productRepository.save(new Product("c",10));
		productRepository.save(new Product("c++",90));
		productRepository.save(new Product("asp",89));
		productRepository.save(new Product("js",109));
	}

	public void sortAll(String property) {
		List<Product> productListAsc = productRepository.findAll(Sort.by(Sort.Order.asc(property)));
		List<Product> productListDesc = productRepository.findAll(Sort.by(Sort.Direction.DESC,property));
	}

	public void showPages(int p, int s) {
		//p start from 0
		Page<Product> page = productRepository.findAll(PageRequest.of(p, s));
		page.getContent().stream().map(Product::getName).forEach(System.out::println);
	}
}

