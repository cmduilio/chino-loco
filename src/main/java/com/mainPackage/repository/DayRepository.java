package com.mainPackage.repository;

import com.mainPackage.model.Day;
import org.springframework.stereotype.Repository;

import java.util.List;

//interface for dayDao, adding getByDay
@Repository
    public class DayRepository extends BaseRepository<Day> {

    public List<Day> getList() {
        return super.getList(Day.class);
    }

    public Day getById(int id) {
        return super.getById(id, Day.class);
    }


    public void remove(int id) {
        super.remove(id, Day.class);
    }
}
