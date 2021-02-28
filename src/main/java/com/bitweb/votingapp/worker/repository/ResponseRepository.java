package com.bitweb.votingapp.worker.repository;

import com.bitweb.votingapp.worker.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
}
