package com.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table
public class Message {
    @Id
    @Column
    private Long id;

    @Column
    private String data;

    public Message(String data) {
        this.data = data;
    }
}
