package br.com.coding.libraryControl.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.coding.libraryControl.model.PublishingCompany;

@Repository
public interface IPublishingCompanyRepository extends JpaRepository<PublishingCompany, UUID>{

}