package com.demo.jooq.jooqdemo;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record5;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.util.List;

import static com.demo.jooq.jooqdemo.db.tables.Human.HUMAN;
import static com.demo.jooq.jooqdemo.db.tables.Student.STUDENT;
import static com.demo.jooq.jooqdemo.db.tables.Address.ADDRESS;
import static org.jooq.impl.DSL.avg;
import static org.jooq.impl.DSL.count;

@SpringBootApplication
public class JooqDemoApplication implements CommandLineRunner {

	@Autowired
	DSLContext context;
	
	public static void main(String[] args) {
		SpringApplication.run(JooqDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}

	/*Result<Record5<String, String, String, String, String>> result = context.select(
			STUDENT.NAME,
			STUDENT.FAMILY,
			ADDRESS.CITY,
			ADDRESS.STREET,
			ADDRESS.ZIPCODE
	)
			.from(STUDENT)
			.innerJoin(ADDRESS)
			.on(ADDRESS.AID.eq(STUDENT.ADDRESS_FK))
			.fetch();
	List<String> values = result.getValues(HUMAN.NAME);
		values.stream().forEach(System.out::println);*/