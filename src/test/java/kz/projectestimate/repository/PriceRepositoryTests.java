package kz.projectestimate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.junit.jupiter.api.Test;

import kz.projectestimate.entity.Price;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class PriceRepositoryTests {
	
	@Autowired
	private PriceRepository repo;
	
	@Test
	public void testGetPriceByPosition() {
		Price price = repo.findPriceByPosition("36. Узел учета нефти производительностью: от 0,5 до 5 тыс. м3/сут");
		Price price2 = repo.findById(48).get();
		System.out.println(price.getValueXmin());
		System.out.println(price2.getValueXmin());
			
		//assertThat(price.getId()).isGreaterThan(0);
	}
	
}
