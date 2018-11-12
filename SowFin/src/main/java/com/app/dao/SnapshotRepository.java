package com.app.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Snapshot;

@Repository
public interface SnapshotRepository extends JpaRepository<Snapshot, String> {

	Snapshot findById(int fileId);

}
