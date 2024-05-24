package soa.homeease.proinventoryservice.repository;

import soa.homeease.proinventoryservice.invent.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    List<Inventory> findByNameIn(List<String> name);
}
