package spittr.data;

import org.springframework.stereotype.Repository;
import spittr.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class SpittleRepository {
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittleList = new ArrayList<>();
        spittleList.add(new Spittle("spittle one", new Date()));
        return spittleList;
    }
}
