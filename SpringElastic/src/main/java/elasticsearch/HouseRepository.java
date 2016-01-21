package elasticsearch;

import com.dellnaresh.db.House;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by nareshm on 13/12/2015.
 */
public interface HouseRepository extends ElasticsearchRepository<House,Long> {
    public List<House> findByAgency(String agency);
}
