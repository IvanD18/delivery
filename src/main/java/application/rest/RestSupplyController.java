package application.rest;

import application.dto.SupplyResponseDto;
import application.entity.FruitEntity;
import application.entity.HistoryEntity;
import application.utils.CustomDeserializer;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.web.bind.annotation.*;
import application.service.DeliveryService;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/supply")

public class RestSupplyController {
    private final DeliveryService deliveryService;


    public RestSupplyController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/test")
    public String sayHello(){
        return "Hello";
    }
    @PostMapping("/make/{date}")
    @JsonDeserialize(using = CustomDeserializer.class)
    public HistoryEntity makeSupply(@RequestBody  Map<String, String> fruits, @PathVariable String date){
        return deliveryService.addToHistory(deliveryService.calculateSupply(fruits, new Date(date)));
    }
}
