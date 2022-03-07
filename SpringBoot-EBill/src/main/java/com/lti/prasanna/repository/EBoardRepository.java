package com.lti.prasanna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.prasanna.entity.EBoard;

@Repository
public interface EBoardRepository extends JpaRepository<EBoard, Integer> {

	List<EBoard> findEBoardByName(String name);
}
