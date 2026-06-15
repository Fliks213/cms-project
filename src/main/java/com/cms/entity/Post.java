package com.cms.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(unique = true, nullable = false, length = 255)
    private String slug;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String content;

    @Column(length = 500)
    private String excerpt;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(50) DEFAULT 'DRAFT'")
    private PostStatus status = PostStatus.DRAFT;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "post_tags",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer viewCount = 0;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer likeCount = 0;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer commentCount = 0;

    private String featuredImageUrl;
    private String seoTitle;
    private String seoDescription;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime publishedAt;
    private LocalDateTime archivedAt;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostVersion> versions;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
