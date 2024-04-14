package com.example.polihack2.repos;

import com.example.polihack2.model.Client;
import com.example.polihack2.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Long>{
}
