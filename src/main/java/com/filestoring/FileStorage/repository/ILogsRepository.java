package com.filestoring.FileStorage.repository;

import com.filestoring.FileStorage.entity.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface ILogsRepository extends JpaRepository<Logs,Long> {
}
