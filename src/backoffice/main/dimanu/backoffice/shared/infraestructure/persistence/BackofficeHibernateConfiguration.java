package dimanu.backoffice.shared.infraestructure.persistence;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@Configuration
@EnableTransactionManagement
public class BackofficeHibernateConfiguration {
    private final String CONTEXT_NAME = "backoffice";

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());

        List<Resource> mappingFiles = searchMappingFiles(CONTEXT_NAME);

        sessionFactory.setMappingLocations(mappingFiles.toArray(new Resource[mappingFiles.size()]));

        return sessionFactory;
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, "none");
        hibernateProperties.put(AvailableSettings.SHOW_SQL, "false");
        hibernateProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQLDialect");

        return hibernateProperties;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(
                "jdbc:mysql://localhost:3306/backoffice?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
        );
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());

        return transactionManager;
    }

    private List<Resource> searchMappingFiles(String contextName) {
        List<String> modules = subdirectoriesFor(contextName);
        List<String> goodPaths = new ArrayList<>();

        for (String module : modules) {
            String[] files = mappingFilesIn(module + "/infra/persistence/hibernate/");

            for (String file : files) {
                goodPaths.add(module + "/infra/persistence/hibernate/" + file);
            }
        }

        return goodPaths.stream().map(FileSystemResource::new).collect(Collectors.toList());
    }

    private List<String> subdirectoriesFor(String contextName) {
        String path = "./src/" + contextName + "/main/dimanu/" + contextName + "/";

        String[] files = new File(path).list((current, name) -> new File(current, name).isDirectory());

        if (null == files) {
            path  = "./main/dimanu" + contextName + "/";
            files = new File(path).list((current, name) -> new File(current, name).isDirectory());
        }

        if (null == files) {
            return Collections.emptyList();
        }

        String finalPath = path;

        return Arrays.stream(files).map(file -> finalPath + file).collect(Collectors.toList());
    }

    private String[] mappingFilesIn(String path) {
        List<String> fileList = new ArrayList<>();

        String[] hbmFiles = new File(path).list((current, name) -> new File(current, name).getName().contains(".hbm.xml"));
        String[] ormFiles = new File(path).list((current, name) -> new File(current, name).getName().contains(".orm.xml"));

        if (hbmFiles != null) {
            fileList.addAll(Arrays.asList(hbmFiles));
        }
        if (ormFiles != null) {
            fileList.addAll(Arrays.asList(ormFiles));
        }

        return fileList.toArray(new String[0]);
    }

}