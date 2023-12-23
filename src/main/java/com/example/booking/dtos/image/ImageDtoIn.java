package com.example.booking.dtos.image;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageDtoIn {
    private String nameImage;
    private String origFileName;
    private Long sizeImage;
    private String contentType;
    private Integer isPreviewImage;
    private Integer orderId;
}
