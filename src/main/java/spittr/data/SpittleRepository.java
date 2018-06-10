package spittr.data;

import spittr.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> fineSpittles(long max, int count);
}
