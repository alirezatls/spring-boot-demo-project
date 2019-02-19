package com.demo.rest.ajax.restdemoajax.service;

import com.demo.rest.ajax.restdemoajax.dto.HumanDto;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.demo.rest.ajax.restdemoajax.db.tables.Human.HUMAN;

@Service
public class HumanService {

    @Autowired
    DSLContext context;

    public HumanDto findHumanById(int id) {
        return context.selectFrom(HUMAN)
                .where(HUMAN.ID.eq(id))
                .fetchAny()
                .into(HumanDto.class);
    }

    public List<HumanDto> findAllHuman() {
        return context.selectFrom(HUMAN)
                .fetch()
                .into(HumanDto.class);
    }

    public int deleteHumanById(int id) {
        return context.deleteFrom(HUMAN)
                .where(HUMAN.ID.eq(id))
                .execute();
    }
}
