package com.demo.jooq.jooqdemo.service;

import com.demo.jooq.jooqdemo.db.tables.records.HumanRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.demo.jooq.jooqdemo.db.tables.Human.HUMAN;
import static com.demo.jooq.jooqdemo.db.tables.Student.STUDENT;
import static com.demo.jooq.jooqdemo.db.tables.Address.ADDRESS;
import static org.jooq.impl.DSL.count;

@Service
public class JooqService {


    DSLContext context;

    @Autowired
    public JooqService(DSLContext context) {
        this.context = context;
    }

    public HumanRecord  fetchOneHuman(int id) {
        return context.select(
                HUMAN.ID,
                HUMAN.NAME,
                HUMAN.FAMILY
        )
                .from(HUMAN)
                .where(HUMAN.ID.equal(id))
                .fetch()
                .into(HUMAN)
                .get(0);
    }

    public List<HumanRecord> fetchAllHuman() {
        return context.select(
                HUMAN.ID,
                HUMAN.NAME,
                HUMAN.FAMILY
        )
                .from(HUMAN)
                .fetch()
                .into(HUMAN)
                .into(HumanRecord.class);
    }

    public List<HumanRecord> fetchHumanDistinc() {
        return context.select(HUMAN.NAME,HUMAN.FAMILY)
                .distinctOn(HUMAN.NAME)
                .from(HUMAN)
                .fetch()
                .into(HumanRecord.class);
    }

    public int humanCount() {
        return context.select(count())
                .from(HUMAN)
                .fetch()
                .into(HUMAN)
                .get(0)
                .value1();
    }

    public int updateHumanById(int id, String name, String family) {
       return context.update(HUMAN)
                .set(HUMAN.NAME,name)
                .set(HUMAN.FAMILY, family)
                .where(HUMAN.ID.eq(id))
                .execute();
    }

    public int deleteById(int id) {
        return context.deleteFrom(HUMAN)
                .where(HUMAN.ID.eq(id))
                .execute();
    }

    public void StudentJoinAddress() {
        context.select(
                STUDENT.NAME,
                STUDENT.FAMILY,
                STUDENT.ADDRESS_FK,
                ADDRESS.CITY,
                ADDRESS.STREET,
                ADDRESS.ZIPCODE
        )
                .from(STUDENT)
                .join(ADDRESS)
                .on(STUDENT.ADDRESS_FK.eq(ADDRESS.AID))
                .fetch();
    }




}
