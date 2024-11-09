package com.filestoring.FileStorage.util;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.filestoring.FileStorage.entity.Logs;
import com.filestoring.FileStorage.repository.ILogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
//@Component
public class DBLoggingAppender extends AppenderBase<ILoggingEvent> {

    @Autowired
    @Lazy
    private ILogsRepository logsRepository;


    public DBLoggingAppender(ILogsRepository logsRepository){
        this.logsRepository = logsRepository;
    }

    @Override
    protected void append(ILoggingEvent iLoggingEvent) {
        Logs logs = new Logs();
        logs.setLocalDateTime(LocalDateTime.now());
        logs.setLogger(iLoggingEvent.getLoggerName());
        logs.setException(iLoggingEvent.getThrowableProxy() != null ? iLoggingEvent.getThrowableProxy().getMessage() : null);
        logs.setMessage(iLoggingEvent.getFormattedMessage());

        logsRepository.save(logs);
    }
}
