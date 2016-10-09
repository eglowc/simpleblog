package com.eglowc.simpleblog.models;

import com.eglowc.simpleblog.models.support.PostAccess;
import com.eglowc.simpleblog.models.support.PostStatus;
import com.eglowc.simpleblog.models.support.PostType;
import com.sun.org.apache.xpath.internal.operations.String;
import lombok.Data;

import javax.persistence.*;

/**
 * @author eglowc<eglowc@gmail.com>
 */
@Entity
@Data
public class Post extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Owner owner;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Enumerated(EnumType.STRING)
    private PostType postType = PostType.PLAIN;

    @Enumerated(EnumType.STRING)
    private PostStatus postStatus = PostStatus.UNSAVED;

    @Enumerated(EnumType.STRING)
    private PostAccess postAccess = PostAccess.PRIVATE;
}
