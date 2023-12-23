package com.example.booking.enities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "image")
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameImage;
    private String origFileName;
    private Long sizeImage;
    private String contentType;
    @Column(name = "bytes", columnDefinition = "longblob")
    private byte[] bytes;
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
}
