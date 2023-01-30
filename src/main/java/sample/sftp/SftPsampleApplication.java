package sample.sftp;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.integration.sftp.session.SftpSession;

@SpringBootApplication
public class SftPsampleApplication {

	public static void main(String[] args) throws Exception {
//		SpringApplication.run(SftPsampleApplication.class, args);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DefaultSftpSessionFactory factory = (DefaultSftpSessionFactory)context.getBean("sftpSessionFactory");
		System.out.println(factory);
		SftpSession session = factory.getSession();
		String[] names = session.listNames("/");
		for (int i = 0; i < names.length; i++) {
			System.out.println(i + ":" + names[i]);
		}
		FileOutputStream fos = new FileOutputStream(new File("C:/home/katsu/tmp/kuso.xml"));
		session.read("docker-compose.yml", fos);
	}

}
