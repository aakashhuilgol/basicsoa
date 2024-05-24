package soa.homeease.proinventoryservice.controller;

import soa.homeease.proinventoryservice.dto.InventoryResponse;
import soa.homeease.proinventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isAvailable(@RequestParam List<String> name){
        return inventoryService.isAvailable(name);
    }
}
