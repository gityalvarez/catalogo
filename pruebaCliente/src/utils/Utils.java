package utils;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import beans.BeanTest;
import beans.interfaces.BeanTestRemote;

public class Utils {
	public static BeanTestRemote doLookup() {
		try {
			Properties props = new Properties();
			props.put("java.naming.factory.url.pkgs", "org.jboss.ejb.client.naming");
			InitialContext context = new InitialContext(props);
			String appName = "";
			String moduleName = "pruebaEJB";
			String distinctName = "";
			String beanName = BeanTest.class.getSimpleName();
			String interfaceName = BeanTestRemote.class.getName();
			String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!"
					+ interfaceName;
			return (BeanTestRemote) context.lookup(name);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
