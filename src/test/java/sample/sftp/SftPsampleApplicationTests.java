package sample.sftp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SftPsampleApplicationTests {

	@Test
	void contextLoads() {
		try {
			
			SftPsampleApplication.main(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
