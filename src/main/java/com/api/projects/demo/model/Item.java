package com.api.projects.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Setter @Getter
@Document(collection = "item")
public class Item {
    @Id
    private String id;
    private String itemName;
    private String itemDescription;
    private String type;
    private String quantity;
    private int price;
}
