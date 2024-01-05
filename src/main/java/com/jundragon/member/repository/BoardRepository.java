package com.jundragon.member.repository;

import com.jundragon.member.entity.BaseEntity;
import com.jundragon.member.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}
