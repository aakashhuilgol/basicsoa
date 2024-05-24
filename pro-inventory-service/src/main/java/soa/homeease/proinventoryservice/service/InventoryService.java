package soa.homeease.proinventoryservice.service;

import soa.homeease.proinventoryservice.dto.InventoryResponse;
import soa.homeease.proinventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isAvailable(List<String> name){
        return inventoryRepository.findByNameIn(name).stream()
                .map(inventory ->
                    InventoryResponse.builder().name(inventory.getName())
                            .isAvailable((inventory.getAvailable()))
                            .build()
                ).toList();
    }
}
