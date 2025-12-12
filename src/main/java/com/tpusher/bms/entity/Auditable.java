package com.tpusher.bms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Auditable {
    @Id
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id = UUID.randomUUID();

    @Column(name = "\"createdAt\"", updatable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @Column(name = "\"updatedAt\"")
    private OffsetDateTime updatedAt = OffsetDateTime.now();

    @Column(name = "\"deletedAt\"")
    private OffsetDateTime deletedAt;
}
