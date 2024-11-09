package com.filestoring.FileStorage.util;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.filestoring.FileStorage.repository.ILogsRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class LogConfiguration {

    private final ILogsRepository logRepository;

    public LogConfiguration(@Lazy ILogsRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Bean
    public DBLoggingAppender getDbLoggingAppender() {
        return new DBLoggingAppender(logRepository);
    }


    @PostConstruct
    public void configureLogAppender() {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        DBLoggingAppender dbLoggingAppender = getDbLoggingAppender();
        dbLoggingAppender.setContext(loggerContext);
        dbLoggingAppender.start();

        Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        logger.addAppender(dbLoggingAppender);
    }

}
