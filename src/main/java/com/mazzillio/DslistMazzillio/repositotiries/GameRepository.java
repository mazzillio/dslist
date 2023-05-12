package com.mazzillio.DslistMazzillio.repositotiries;

import com.mazzillio.DslistMazzillio.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
