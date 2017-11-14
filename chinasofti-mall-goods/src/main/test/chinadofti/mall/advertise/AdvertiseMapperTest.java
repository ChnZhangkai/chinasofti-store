package chinadofti.mall.advertise;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chinasofti.mall.common.entity.AdvertisePosition;
import com.chinasofti.mall.goods.mapper.AdvertiseContentsMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdvertiseMapperTest {
	
	@Autowired
	AdvertiseContentsMapper advertiseContentsMapper;
	
	@Test
	public void findAdPostionAllTest() {
		
		List<AdvertisePosition> findAdPostionAll = advertiseContentsMapper.findAdPostionAll();
		System.out.println(findAdPostionAll.size());
	}
}
