package com.mmdworks.recap.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmdworks.recap.domain.UserDocument;

public interface UserDocumentRepository extends JpaRepository<UserDocument, Long> {

}
