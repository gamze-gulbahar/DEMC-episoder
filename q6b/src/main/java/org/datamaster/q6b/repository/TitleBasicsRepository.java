package org.datamaster.q6b.repository;

import org.datamaster.q6b.entity.TitleBasics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;

import java.util.List;

@Repository
public interface TitleBasicsRepository extends JpaRepository<TitleBasics, String> {

    @QueryHints(value = @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE, value = "-2147483648"))
    @Query(value = "SELECT primary_title, tr.average_rating, te.season_number, te.episode_number\n" +
            "FROM title_basics tb\n" +
            "JOIN title_episode te on tb.tconst = te.tconst\n" +
            "JOIN title_ratings tr on te.tconst = tr.tconst\n" +
            "WHERE te.parent_tconst = (\n" +
            "    select tconst\n" +
            "    from title_basics\n" +
            "    where title_type = 'tvSeries'\n" +
            "      and primary_title=?1)\n" +
            "ORDER BY average_rating LIMIT 5", nativeQuery = true)
    List<Object[]> findEpisodeRatingsByTitle(String title);
}
