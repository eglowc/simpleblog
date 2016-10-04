package com.eglowc.simpleblog.models;

import com.eglowc.simpleblog.models.support.PostAccess;
import com.eglowc.simpleblog.models.support.PostStatus;
import com.eglowc.simpleblog.models.support.PostType;
import com.sun.org.apache.xpath.internal.operations.String;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Max;

/**
 * Created by HCLEE on 2016. 10. 4..
 *
 * @author HCLEE
 */
@Entity
@Data
public class Post extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Owner owner;

    @NotBlank
    @Max(value = 90)
    private String title;

    @NotBlank
    private String contents;

    @Enumerated(EnumType.STRING)
    private PostType postType = PostType.PLAIN;

    @Enumerated(EnumType.STRING)
    private PostStatus postStatus = PostStatus.UNSAVED;

    @Enumerated(EnumType.STRING)
    private PostAccess postAccess = PostAccess.PRIVATE;
}
